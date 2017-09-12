package main.java.test.Config;

import main.java.test.DAO.HelloService;
import main.java.test.DAO.HelloServiceImpl;
import main.java.test.DAO.HelloServiceImpl2;
import main.java.test.service.DemoService;
import main.java.test.service.DemoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class testConfig {
    @Bean(name="hs1")
    public HelloService hs1() {
        return new HelloServiceImpl();
    }

    @Bean(name="hs2")
    public HelloService hs2() {
        return new HelloServiceImpl2();
    }


//    @Bean(name="demoService")
//    public DemoService sv() {
//        return new DemoServiceImpl();
//    }
}
