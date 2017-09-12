package main.java.test.DAO;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class testPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof testInitDest){
            System.out.println("BeforeInitialization : " + beanName);
            return bean;  // you can return any other object as well
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().equals(testInitDest.class)){
            System.out.println("AfterInitialization : " + beanName);
            return bean;  // you can return any other object as well
        }
        return bean;
    }
}
