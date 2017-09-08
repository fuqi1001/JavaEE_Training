package main.java.antra.springDemo.dao;


import org.springframework.stereotype.Repository;

@Repository // default name = demoDAOImpl
public class DemoDAOImpl2 implements DemoDAO {
    private String message = "implement two";

    @Override
    public void doSomething(){
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
        System.out.println("In save DEMO");
    }
    @Override
    public void test1234() {
        System.out.println("Inside testmethod");
        throw new RuntimeException();
    }
}
