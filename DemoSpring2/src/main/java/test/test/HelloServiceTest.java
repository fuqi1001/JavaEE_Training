package main.java.test.test;

import main.java.test.Config.testConfig;
import main.java.test.DAO.HelloService;
import main.java.test.DAO.testInitDest;
import main.java.test.service.DemoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloServiceTest {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        HelloService helloService = context.getBean("helloService", HelloService.class);
        helloService.sayHello();

        ApplicationContext ac2 = new AnnotationConfigApplicationContext(testConfig.class);
        HelloService ahs = (HelloService) ac2.getBean("hs1");
        HelloService bhs = (HelloService) ac2.getBean("hs2");
        ahs.sayHello();
        bhs.sayHello();

        System.out.println("----------Test aop-------------");
        ahs.testAop("str a", "str b");
        //ahs.testThrowsEx();
        System.out.println("----------Test aop-------------");
        bhs.testAop("str2 a", "str2 b");
        //test throws exception
        //bhs.testThrowsEx();


        System.out.println("----------Test service-------------");
        DemoService demoService = (DemoService)context.getBean("demoService", DemoService.class);
        demoService.doSomething();

        System.out.println("----------Test init and destroy-------------");
        AbstractApplicationContext context2 = new ClassPathXmlApplicationContext("application-context.xml");
        testInitDest tt = (testInitDest) context2.getBean("testInitDest");
        tt.setMessage("hello??");
        tt.getMessage();
        context2.registerShutdownHook();
    }
}
