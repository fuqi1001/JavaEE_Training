package main.java.test.DI;


import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class TextEditor2 {
    @Resource (name = "spellChecker2")
    private SpellChecker2 spellChecker2;
    // a setter method to inject the dependency.
    public void setSpellChecker2(SpellChecker2 spellChecker2) {
        System.out.println("Inside setSpellChecker222." );
        this.spellChecker2 = spellChecker2;
    }

    public SpellChecker2 getSpellChecker2() {
        return spellChecker2;
    }

    public void spellChecker2() {
        spellChecker2.checkSpelling();
    }
}
