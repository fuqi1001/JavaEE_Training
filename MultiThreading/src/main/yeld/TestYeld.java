package main.yeld;

public class TestYeld {
    public static void main(String[] args) {
        System.out.println("Main thread is running");
        ThreadWithClass thread1 = new ThreadWithClass("t1");
        ThreadWithClass thread2 = new ThreadWithClass("t2");
        ThreadWithClass thread3 = new ThreadWithClass("t3");
        ThreadWithClass thread4 = new ThreadWithClass("t4");
        Thread thread5 = new Thread(new ThreadWithInterface());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        System.out.println("Main thread is done");
    }
}
