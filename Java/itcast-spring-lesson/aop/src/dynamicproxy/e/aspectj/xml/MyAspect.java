package dynamicproxy.e.aspectj.xml;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;

/**
 * 切面类，含有多个通知
 */
public class MyAspect {
    // 前置通知
    public void before(JoinPoint joinPoint) {
        System.out.println("before..." + joinPoint.getSignature().getName());
    }
    public void after() {
        System.out.println("after...");
    }

}
