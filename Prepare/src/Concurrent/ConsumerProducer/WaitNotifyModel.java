package Concurrent.ConsumerProducer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class WaitNotifyModel implements Model {

    private final Object BUFFER_LOCK = new Object();
    private final Queue<Task> buffer = new LinkedList<>();
    private final AtomicInteger increTaskNo = new AtomicInteger(0);
    private final int cap;
    public WaitNotifyModel(int cap) {
        this.cap = cap;
    }

    private class ConsumerImpl extends AbstractConsumer implements  Consumer, Runnable {

        @Override
        public void consumer() throws InterruptedException {
            synchronized (BUFFER_LOCK) {
                while (buffer.size() == 0) {
                    BUFFER_LOCK.wait();
                }
                Task task = buffer.poll();
                assert task != null;
                Thread.sleep(500 + (long) (Math.random() * 500));
                System.out.println("Consume: " + task.no);
                BUFFER_LOCK.notifyAll();
            }
        }
    }

    private class ProducerImple extends AbstractProducer implements Producer, Runnable {

        @Override
        public void produce() throws InterruptedException {
            Thread.sleep((long) (Math.random() * 1000));
            synchronized (BUFFER_LOCK) {
                while(buffer.size() == cap) {
                    BUFFER_LOCK.wait();
                }
                Task task = new Task(increTaskNo.getAndIncrement());
                buffer.offer(task);
                System.out.println("Produce: " + task.no);
                BUFFER_LOCK.notifyAll();
            }
        }
    }

    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }

    @Override
    public Runnable newRunnableProducer() {
        return new ProducerImple();
    }

    public static void main(String[] args) {
        Model model = new WaitNotifyModel(3);
        for(int i = 0; i < 2; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
        for(int i = 0; i < 5; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
}
