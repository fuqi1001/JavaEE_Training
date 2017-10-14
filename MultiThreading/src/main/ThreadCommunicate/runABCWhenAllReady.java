package main.ThreadCommunicate;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class runABCWhenAllReady {
    private static void runReady() {
        int runner = 3;
        CyclicBarrier cb = new CyclicBarrier(runner);
        final Random random = new Random();
        for(char runnerName = 'A'; runnerName <= 'C'; runnerName++) {
            final String rN = String.valueOf(runnerName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long prepareTime = random.nextInt(10000) + 100;
                    System.out.println(rN + " is preparing for time: " +  prepareTime);
                    try {
                        Thread.sleep(prepareTime);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        System.out.println(rN + " is prepared, waiting for others");
                        cb.await();     //当前准备完毕，等待其他人
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(rN + " starts running");
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        runReady();
    }

}
