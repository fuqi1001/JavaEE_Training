package main.java.test.DAO;


import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository
public class testInitDest {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("Your message: " + message);
    }
    @PostConstruct
    public void init(){
        System.out.println("Bean is going through init.");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("Bean will destroy now.");
    }


}
