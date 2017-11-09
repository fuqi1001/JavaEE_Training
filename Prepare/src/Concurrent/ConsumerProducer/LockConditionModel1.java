package Concurrent.ConsumerProducer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionModel1 implements Model {

    private final Lock BUFFER_LOCK = new ReentrantLock();
    private final Condition BUFFER_COND = BUFFER_LOCK.newCondition();
    private final Queue<Task> buffer = new LinkedList<>();
    private final int cap;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public LockConditionModel1(int cap) {
        this.cap = cap;
    }

    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }

    @Override
    public Runnable newRunnableProducer() {
        return new ProducerImpl();
    }

    private class ConsumerImpl extends AbstractConsumer implements Runnable, Consumer{
        @Override
        public void consumer() throws InterruptedException {
            BUFFER_LOCK.lockInterruptibly();
            try {
                while(buffer.size() == 0) {
                    BUFFER_COND.await();
                }
                Task task = buffer.poll();
                assert task != null;

                Thread.sleep(500 + (long) (Math.random() * 500 ));
                System.out.println("consume: " + task.no);
                BUFFER_COND.signalAll();
            } finally {
                BUFFER_LOCK.unlock();
            }
        }
    }

    private class ProducerImpl extends AbstractProducer implements Runnable, Producer {
        @Override
        public void produce() throws InterruptedException {
            Thread.sleep((long) (Math.random() * 1000)) ;
            BUFFER_LOCK.lockInterruptibly();
            try {
                while(buffer.size() == cap){
                    BUFFER_COND.await();
                }
                Task task = new Task(increTaskNo.getAndIncrement());
                buffer.offer(task);
                System.out.println("Produce: " + task.no);
                BUFFER_COND.signalAll();
            } finally {
                BUFFER_LOCK.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Model model = new LockConditionModel1(3);
        for(int i = 0; i < 2; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
        for(int i = 0; i < 5; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
}
