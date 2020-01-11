package dynamicproxy.b.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 */
public class MyBeanFactory {
    
    public static UserServiceImpl createService() {
        // 1 目标类
        final UserServiceImpl userService = new UserServiceImpl();
        // 2 切面类
        final MyAspect myAspect = new MyAspect();
        // 3 代理类，采用cglib，底层创建目标类的子类
        // 3.1 核心类
        Enhancer enhancer = new Enhancer();
        // 3.2 确定父类
        enhancer.setSuperclass(userService.getClass());
        /** 3.3 设置回调函数, MethodInterceptor 等效 jdk InvocationHandler
         * intercept 等效 jdk 的 invoke 方法
         *   参数1、参数2、参数3 与 invoke 一样
         *   参数4：方法的代理
         */
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                myAspect.before();
                Object object = method.invoke(userService, args);
                // 效果等上，这里执行代理类 proxy 的父类，也就是目标类 userService
                // methodProxy.invokeSuper(proxy, args);
                myAspect.after();
                return object;
            }
        });
        // 3.4 创建代理
        UserServiceImpl proxyService = (UserServiceImpl) enhancer.create();
        
        return proxyService;
    }

    public static void main(String[] args) {
        UserServiceImpl userService = MyBeanFactory.createService();
        userService.addUser();
        userService.updateUser();
    }
}
