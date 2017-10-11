package main.yeld;

public class ThreadWithInterface implements Runnable {
    @Override
    public void run() {
        System.out.println("ThreadWithInterface 1 is running");
        for(int i = 0; i < 10; i++) {
            System.out.println("ThreadWithInterface: " + i);
        }
        System.out.println("ThreadWithInterface is done");
    }
}
