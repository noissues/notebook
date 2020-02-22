package dynamicproxy.e.aspectj.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestAspectJXml {

    public static void main(String[] args) {
        String xmlPath = "dynamicproxy/e/aspectj/xml/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        // 测试配切面之前的执行是否成功(这里就是直接获得目标类了，代理的工作 Spring 会替我们做)
        UserService userService = (UserService) applicationContext.getBean("userServiceId");
        userService.addUser();
        userService.updateUser();
    }
}

