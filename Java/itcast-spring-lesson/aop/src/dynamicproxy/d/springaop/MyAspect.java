package dynamicproxy.d.springaop;


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
        // 目标方法执行前，执行的方法
        before();
        // 手动执行目标方法
        Object obj = methodInvocation.proceed();
        // 目标方法执行后，执行的方法
        after();
        return obj;
    }
}
