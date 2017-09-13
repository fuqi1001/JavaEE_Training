package main.java.test.test;

import main.java.test.DI.JavaCollection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DICollectionTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        JavaCollection jc = (JavaCollection) context.getBean("javaCollection");

        jc.getAddressList();
        jc.getAddressMap();
        jc.getAddressProp();
        jc.getAddressSet();

    }
}
