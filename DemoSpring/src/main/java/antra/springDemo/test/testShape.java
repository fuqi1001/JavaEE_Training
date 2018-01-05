package main.java.antra.springDemo.test;

import main.java.antra.springDemo.service2.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testShape {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
        ShapeService shapeService = ac.getBean("shapeService", ShapeService.class);

        //other way
        //ShapeService shapeService = (ShapeService) ac.getBean("shapeService");


        //fire args()
        shapeService.getCircle().setName("Dummy name");



        System.out.println(shapeService.getCircle().getName());
    }

}
