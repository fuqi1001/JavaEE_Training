package main.java.antra.springDemo.aop;


import main.java.antra.springDemo.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {


    //@Before("execution(public String getName())")
    //@Before("execution( * get*())")
    //@Before("execution( * get*(..))")  ..mean 0 or multi / (*) mean 1 or more
    //@Before("execution(public * get*())")
    //Joinpoint:which specific method called
    @Before("allCircleMethods()")
    public void LoggingAdvice(JoinPoint joinPoint) {
        System.out.println(joinPoint.toString());
        System.out.println(joinPoint.getTarget());  //get Object
//        Circle circle = (Circle) joinPoint.getTarget();
//        circle.getName();
    }

    @Before("args(name)")
    public void stringArgumentMethods(String name) {
        System.out.println("A method that takes String arguments has been called. The value is " + name);
    }


    /*
    //@Before("execution(public * get*())")
    @Before("allGetters() && allCircleMethods()")
    public void secondAdvice() {
        System.out.println("Second Advice run");
    }
    */


    //Define a pointcut
    @Pointcut("execution(public * get*())")
    public void allGetters(){
        //dummy method
    }

    //@Pointcut("execution(* * main.java.antra.springDemo.model.Circle.*(..))")
    //@Pointcut("within(main.java.antra.springDemo.model.Circle)")
    //@Pointcut("within(main.java.antra.springDemo.model..*)") '..' mean in the package or sub package
    @Pointcut("within(main.java.antra.springDemo.model.*)")
    public void allCircleMethods() {}

}
