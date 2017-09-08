package main.java.antra.springDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//@Configuration
//@ComponentScan(basePackages = { "main.java.antra.springDemo" })
public class MyConfig {
    @Bean(name="myString")
    public String getAString() {
        return "hello";
    }
}
