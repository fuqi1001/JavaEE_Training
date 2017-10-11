package main.producerConsumer.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Producer extends Thread{
    private BlockingQueue<String> productList = new ArrayBlockingQueue<String>(20);
    private static int pNo = 1;
    private int maxNum;
    public Producer(int max) {
        this.maxNum = max;
    }

    public void produce() throws InterruptedException {
        productList.add("Product number: " + pNo);
        System.out.println("Product is ready: #" + pNo);
        pNo++;
    }
    public String getProduct() throws InterruptedException {
        String res = productList.take();
        return res;
    }
    @Override
    public void run() {
        System.out.println("Producer is running............");
        try {
            for(int i = 0; i < maxNum; i++) {
                produce();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Producer is done...............");
    }


}
