package dynamicproxy.c.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestFactoryBean {

    public static void main(String[] args) {
        String xmlPath = "dynamicproxy/c/factorybean/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        // 测试配切面之前的执行是否成功
        // UserService userService = (UserService) applicationContext.getBean("userServiceId");
        // userService.addUser();
        // userService.updateUser();
        // 测试配置切面是否成功
        UserService userService = (UserService) applicationContext.getBean("proxyServiceId");
        userService.addUser();
        userService.updateUser();
    }
}

