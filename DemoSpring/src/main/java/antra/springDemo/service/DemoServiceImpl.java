package main.java.antra.springDemo.service;

import main.java.antra.springDemo.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("aService")
public class DemoServiceImpl implements DemoService {

    @Autowired
    @Qualifier("demoDAOImpl2")
    DemoDAO aDAO2;


    @Autowired
    @Qualifier("demoDAOImpl")
    DemoDAO aDAO;


    @Override
    public void doSomething() {
        aDAO.doSomething();
    }

    public DemoDAO getaDAO() {
        return aDAO;
    }
}
