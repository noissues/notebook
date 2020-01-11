package dynamicproxy.a.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 */
public class MyBeanFactory {
    
    public static UserService createService() {
        /**
         * 匿名函数要求外部变量为 final
         * 目标对象 userService 被代理的对象
         * 切面对象 myAspect
         * 代理对象 userServiceProxy
         */
        final UserService userService = new UserServiceImpl();
        final MyAspect myAspect = new MyAspect();
        
        /**
         * param1: 类加载器，动态代理类，运行时创建，任何类都需要类加载器加在到内存
         *         方式1: 当前类.class.getClassLoader 方式2: 目标类.getClass().getClas..
         * param2: interfaces 代理类需要实现的所有接口
         *         方式1: 目标类.getClass().getInterfaces() (只能获得自己接口，不能获得父元素接口)
         *         方式2: new Class[] {UserService.class} 例如: jdbc 驱动->DriverManager.getConnection
         * param3: InvocationHandler 处理类 接口，一般采用匿名内部类
         *         提供 invoke 方法，代理类的每一个方法执行时，都将调用一次 invoke
         *         param1: Object proxy: 代理对象
         *         param2: Method method: 代理对象当前执行的方法的描述对象（反射）
         *         param3: Objecy[] args: 方法实际参数
         */
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(MyBeanFactory.class.getClassLoader(),
            userService.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    myAspect.before();
                    // 执行目标类的方法
                    Object result = method.invoke(userService, args);
                    myAspect.after();
                    return result;
                }
            });
        return userServiceProxy;
    }

    public static void main(String[] args) {
        UserService userService = MyBeanFactory.createService();
        userService.addUser();
        userService.updateUser();
    }
}
