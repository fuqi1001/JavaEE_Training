package main.waitnotify;

public class TestWaitNotify {
    public static void main(String[] args) throws InterruptedException{
        TestWaitNotify test = new TestWaitNotify();
        test.test();
    }

    public void test() throws InterruptedException {
        System.out.println("Main thread is running");
        Thread thread1 = new Thread(new ThreadWithInterface());
        ThreadWithClass thread2 = new ThreadWithClass();
        thread1.start();
        thread2.start();
        thread1.join();
        synchronized (thread2) {
            thread2.notify();
        }
        System.out.println("Main thread is done");
    }
}
