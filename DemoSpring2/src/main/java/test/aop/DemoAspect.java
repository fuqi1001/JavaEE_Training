package main.java.test.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect {
    @Before("execution(* *.test*(..))")
    public void getNameAdvice(JoinPoint joinPoint){
        System.out.println("Before test*");
        Object[] signatureArgs = joinPoint.getArgs();
        for(Object obj : signatureArgs) {
            System.out.println("Args: " + obj);
        }
    }


    @AfterThrowing("execution(* *.testThrowsEx*(..))")
    public void afterThrow() {
        System.out.println("aop for testThrowsEx");
    }

    @After("execution(* *.test*(..))")
    public void afterMethod() {
        System.out.println("after test*");
    }

    @Around("execution(* *.test*(..))")
    public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("Before invoking save() method");
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("After invoking save() method. Return value="+value);
        return value;
    }

}
