package main.java.antra.springDemo.dao;

import org.springframework.stereotype.Repository;

@Repository // default name = demoDAOImpl
public class DemoDAOImpl implements DemoDAO{

    private String message = "implement one ";
    @Override
    public void doSomething() {
        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void saveDemo(String a, String b) {
        System.out.println("in implement1 save");
    }

    @Override
    public void test1234() {
        System.out.println("inside implement1 test");
        throw new RuntimeException();
    }
}
