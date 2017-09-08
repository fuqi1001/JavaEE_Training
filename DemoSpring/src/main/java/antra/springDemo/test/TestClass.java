package main.java.antra.springDemo.test;

import main.java.antra.springDemo.dao.DemoDAO;
import main.java.antra.springDemo.service.DemoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
//		DemoAspect bean = (DemoAspect)ac.getBean("a3");
//		DemoAspect bean2 = (DemoAspect)ac.getBean("a2");

//		System.out.println(bean == bean2);

//
        DemoDAO aDAO = (DemoDAO)ac.getBean("demoDAOImpl");
        aDAO.test1234();
	//	DemoService aService = (DemoService)ac.getBean("aService");
	//	aService.doSomething();


        //
//		ApplicationContext ac2 = new AnnotationConfigApplicationContext(MyConfig.class);
//		DemoDAO aDAO = (DemoDAO)ac2.getBean("demoDAOImpl");
//		String s = (String)ac2.getBean("myString");
//		System.out.println(s);
//		aDAO.saveDemo("123","456");
    }

}
