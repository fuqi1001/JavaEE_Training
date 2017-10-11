package main.waitnotify.PC;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerInJava {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("How to use wait and notify method in Java");
        System.out.println("Solving Producer Consumer Problem");
        Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 10;
        Thread producer = new Producer(buffer, maxSize, "Producer");
        Thread consumer = new Consumer(buffer, maxSize, "Consumer");
        producer.start();
        consumer.start();


        System.out.println("Main thread end");
    }

    static class Producer extends Thread {
        private Queue<Integer> queue;
        private int maxSize;

        public Producer(Queue<Integer> queue, int maxSize, String name) {
            super(name);
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == maxSize) {
                        try {
                            System.out.println("Queue is full, "
                                    + "Producer thread waiting for " + "consumer to take something for queue");
                            queue.wait();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }
                    Random random = new Random();
                    int i = random.nextInt();
                    System.out.println("Producing value: " + i);
                    queue.add(i);
                    queue.notifyAll();
                }
            }
        }
    }

    static class Consumer extends Thread {
        private Queue<Integer> queue;
        private int maxSize;

        public Consumer(Queue<Integer> queue, int maxSize, String name) {
            super(name);
            this.maxSize = maxSize;
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        System.out.println("Queue is empty, " +
                                "Consumer thread is waiting " +
                                "for producer thread to put something in queue");
                        try {
                            queue.wait();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    System.out.println("Consuming value: " + queue.remove());
                    queue.notifyAll();
                }
            }
        }
    }
}
