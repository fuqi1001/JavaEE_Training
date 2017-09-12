package main.java.test.DAO;


import main.java.test.DAO.HelloService;
import org.springframework.stereotype.Repository;

@Repository
public class HelloServiceImpl2 implements HelloService {

    @Override
    public void sayHello() {
        System.out.println("Say hello 2");
    }

    @Override
    public void testAop(String a, String b) {
        System.out.println("impl2 test aop a: " + a +" b: "+ b);
    }

    @Override
    public void testThrowsEx() {
        System.out.println("impl2 test aop throws");
        throw new RuntimeException();
    }
}
