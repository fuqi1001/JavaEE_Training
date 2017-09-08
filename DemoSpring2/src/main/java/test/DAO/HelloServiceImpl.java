package main.java.test.DAO;

import main.java.test.DAO.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("Say hello");
    }

    @Override
    public void testAop(String a, String b) {
        System.out.println("impl1 test aop a: " + a +" b: "+ b);
    }

    @Override
    public void testThrowsEx() {
        System.out.println("impl1 test aop throws");
        throw new RuntimeException();
    }
}
