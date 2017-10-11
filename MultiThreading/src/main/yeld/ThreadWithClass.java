package main.yeld;

public class ThreadWithClass extends Thread {
    public ThreadWithClass(String threadName) {
        this.setName(threadName);
    }

    @Override
    public void run() {
        System.out.println("ThreadWithClass is running");
        for(int i = 0; i < 10; i++) {
            System.out.println("Thread name: " + this.getName()+" : "+i);
            Thread.yield();
        }
        System.out.println("ThreadWithClass is done");
    }
}
