package main.ThreadCommunicate;

import java.util.concurrent.CountDownLatch;

public class CountDown {
    private static void runDAfterABC() {
        int worker = 3;
        CountDownLatch cd = new CountDownLatch(worker); //一个线程去等待多个
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("D is waiting for other three threads");
                try {
                    cd.await();
                    System.out.println("All done, D starts working");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();

        for(char threadName='A'; threadName <= 'C'; threadName++) {
            final String tN  = String.valueOf(threadName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(tN + " is working");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(tN + " finished");
                    cd.countDown();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        runDAfterABC();
    }
}
