package main.join;

import main.ThreadWithClass;
import main.ThreadWithInterface;

public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread is running");
        Thread thread1 = new Thread(new ThreadWithInterface());
        ThreadWithClass thread2 = new ThreadWithClass();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        /*
            thread1.join 与 thread2.join
            阻塞了调用这两个线程的主线程(calling thread)
            等待其他线程完成后，主线程Main才完成
         */
        System.out.println("Main thread is done");
    }
}
