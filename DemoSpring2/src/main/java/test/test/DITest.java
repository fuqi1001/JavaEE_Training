package main.java.test.test;

import main.java.test.DI.TextEditor;
import main.java.test.DI.TextEditor2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        TextEditor te = (TextEditor) context.getBean("textEditor");
        te.spellCheck();

        TextEditor2 te2 = (TextEditor2)  context.getBean("textEditor2");
        te2.spellChecker2();
    }
}
