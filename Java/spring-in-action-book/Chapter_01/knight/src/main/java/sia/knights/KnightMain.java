package sia.knights;

import org.springframework.context.support.
                   ClassPathXmlApplicationContext;

public class KnightMain {

  // Spring 通过上下文（ApplicationContext）装载 bean 的定义并将之组装起来
  public static void main(String[] args) throws Exception {
    // 通过 XML 的方式加载 Spring 的上下文
    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("META-INF/spring/minstrel.xml");
        // new ClassPathXmlApplicationContext("META-INF/spring/knight.xml");
    Knight knight = context.getBean(Knight.class);
    knight.embarkOnQuest();
    context.close();
  }
}
