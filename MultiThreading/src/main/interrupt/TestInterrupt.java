package main.interrupt;

public class TestInterrupt {
    public static void main(String[] args) {
        System.out.println("Main thread is running");
        Thread thread1 = new Thread(new ThreadWithClass());
        ThreadWithClass thread2 = new ThreadWithClass();
        thread1.start();
        thread2.start();
        thread2.interrupt();
        System.out.println("Main thread is done");
    }
}
