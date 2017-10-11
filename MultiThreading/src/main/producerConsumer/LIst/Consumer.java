package main.producerConsumer.LIst;

public class Consumer extends Thread{
    private Producer producer;
    private int productMaxQuantity;
    public Consumer(Producer producer, int max) {
        this.producer = producer;
        this.productMaxQuantity = max;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " Consumer is running ........");
        for(int i = 0; i < productMaxQuantity; i++) {
            try {
                String product = producer.getProduct();
                System.out.println(this.getName() + " get: " + product);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(this.getName() + " is done ..........");
    }
}
