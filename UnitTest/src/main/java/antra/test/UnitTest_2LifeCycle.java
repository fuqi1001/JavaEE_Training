package main.java.antra.test;

import org.junit.*;

import static org.junit.Assert.*;

public class UnitTest_2LifeCycle {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("before all test class executed...");
    }

    @Before
    public void before() {
        System.out.println("before each test class executed...");
    }

    @Test
    public void testMethod() {
        assertTrue(100/2 == 50);
    }

    @Test
    public void testMethod2() {
        assertFalse(100/2 == 10);
    }


    @After
    public void after() {
        System.out.println("After each test is executed...");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After all test are executed...");
    }
}
