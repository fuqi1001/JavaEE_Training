package main.yeld;



public class YieldExample {
    public static void main(String[] args) throws InterruptedException{
        Thread producer = new Producer();
        Thread consumer = new Consumer();

        producer.setPriority(Thread.MIN_PRIORITY);
        consumer.setPriority(Thread.MAX_PRIORITY);

        //producer.start();
        //consumer.start();



        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("First task started");
                System.out.println("Sleeping for 2 seconds");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("First task completed");
            }
        });
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Second task completed");
            }
        });
        t.start();
        t.join();
        t1.start();
    }

    static class Consumer extends Thread {
        public void run() {
            for(int i = 0; i < 5; i++) {
                System.out.println("I am Consumer : Consumed Item " + i);
                Thread.yield();
            }
        }
    }

    static class Producer extends Thread {
        public void run() {
            for(int i = 0; i < 5; i++) {
                System.out.println("I am Producer : Produced Item " + i);
                Thread.yield();
            }
        }
    }

}
