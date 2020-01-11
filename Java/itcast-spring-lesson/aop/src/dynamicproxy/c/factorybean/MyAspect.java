package dynamicproxy.c.factorybean;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 切面类中确定通知，需要实现不同接口，接口就是规范，从而就确定方法名
 * 这里采用 AOP 联盟的 环绕通知 MethodInterceptor
 */
public class MyAspect implements MethodInterceptor {
    public void before() {
        System.out.println("before...");
    }
    public void after() {
        System.out.println("after...");
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        // 手动执行目标方法
        Object obj = methodInvocation.proceed();
        after();
        return obj;
    }
}
