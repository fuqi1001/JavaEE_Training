package main.java.test.service;


import main.java.test.DAO.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Repository
@Service("demoService")
public class DemoServiceImpl implements DemoService {



    @Autowired
    @Qualifier("helloServiceImpl")
    HelloService hs3;


    @Autowired
    @Qualifier("helloServiceImpl2")
    HelloService hs4;


    @Override
    public void doSomething() {
        hs3.testAop("str2 hs3", "str1 hs3");
        getHs4();
    }

    public HelloService getHs4() {
        return hs4;
    }
}
