package main.join;

import main.ThreadWithClass;
import main.ThreadWithInterface;

public class TestIsAlive {
    public static void main(String[] args) {
        System.out.println("Main thread is running");
        Thread thread1 = new Thread(new ThreadWithInterface());
        ThreadWithClass thread2 = new ThreadWithClass();

        thread1.start();
        thread2.start();
        //thread1.join();//comment out this line make difference
        //thread2.join();
        System.out.println("////////////thread1 is alive?/////////// "+thread1.isAlive());
        System.out.println("////////////thread2 is alive?/////////// "+thread2.isAlive());
        System.out.println("Main thread is done");

    }
}
