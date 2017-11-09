package DesignPattern.Singleton;

import java.lang.reflect.Constructor;

public class ReflectionSingletonTest {
    public static void main(String[] args) {
        EagerInitializedSingleton i1 = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton i2 = null;
        try {
            Constructor[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
            for(Constructor c : constructors) {
                //Below code will destroy the singleton pattern
                c.setAccessible(true);
                i2 = (EagerInitializedSingleton)c.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(i1.hashCode());
        System.out.println(i2.hashCode());
    }
}
