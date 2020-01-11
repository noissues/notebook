package dynamicproxy.a.jdk;

/**
 */
public class MyAspect {
    public void before() {
        System.out.println("before...");
    }
    public void after() {
        System.out.println("after...");
    }
}
