package main.join;

public class JoinTester02 implements Runnable {

    Thread thread;

    public JoinTester02(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        synchronized (thread) {
            System.out.println("getObjectLock");
            try {
                Thread.sleep(9000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("ReleaseObjectLock");
        }
    }

    /*
        getLockThread通过 synchronized  (thread) ，获取线程对象t的锁，并Sleep（9000）后释放，
        这就意味着，即使main方法t.join(1000)等待一秒钟，它必须等待ThreadTest 线程释放t锁后才能进入wait方法中。
     */
    public static void main(String[] args) {
        Thread thread = new Thread(new JoinTester01("Three"));
        Thread getLockThread = new Thread(new JoinTester02(thread));

        getLockThread.start();
        thread.start();

        try{
            thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Main finished");
    }
}
