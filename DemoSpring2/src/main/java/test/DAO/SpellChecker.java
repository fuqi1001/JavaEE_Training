package main.java.test.DAO;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class SpellChecker {
    public SpellChecker(){
        System.out.println("Inside SpellChecker constructor." );
    }
    public void checkSpelling() {
        System.out.println("Inside checkSpelling." );
    }
}
