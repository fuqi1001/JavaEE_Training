package main.java.test.DI;


import org.springframework.stereotype.Repository;

@Repository
public class SpellChecker2 {
    public SpellChecker2(){
        System.out.println("Inside SpellChecker2222 constructor." );
    }
    public void checkSpelling() {
        System.out.println("Inside checkSpelling2222." );
    }
}
