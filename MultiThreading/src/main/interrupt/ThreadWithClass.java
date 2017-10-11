package main.interrupt;

public class ThreadWithClass extends Thread {
    Object lock = new Object();
    @Override
    public void run() {
        System.out.println(this.getName() + " ThreadWithClass is running");
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i < 10 ; i++) {
            System.out.println( this.getName() + " ThreadWithClass : " + i);
            try {
                Thread.sleep(500);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ThreadWithClass is done");
    }
}
