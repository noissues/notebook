package dynamicproxy.d.springaop;

import dynamicproxy.d.springaop.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpringAop {

    public static void main(String[] args) {
        String xmlPath = "dynamicproxy/d/springaop/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        // 测试配切面之前的执行是否成功(这里就是直接获得目标类了，代理的工作 Spring 会替我们做)
        UserService userService = (UserService) applicationContext.getBean("userServiceId");
        userService.addUser();
        userService.updateUser();
        // 测试配置切面是否成功
        // UserService userService = (UserService) applicationContext.getBean("proxyServiceId");
        // userService.addUser();
        // userService.updateUser();
    }
}

