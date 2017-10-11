package main.producerConsumer.LIst;

public class TestProdCons {
    public static void main(String[] args) throws InterruptedException{
        TestProdCons test = new TestProdCons();
        test.go();
    }

    public void go() throws InterruptedException {
        Producer producer = new Producer(20);

        Consumer consumer1 = new Consumer(producer, 10);
        consumer1.setName("Consumer 1");

        Consumer consumer2 = new Consumer(producer, 10);
        consumer2.setName("Consumer 2");

        consumer1.start();
        consumer2.start();
        producer.start();

        consumer1.join();
        consumer2.join();
        producer.join();

        System.out.println("All done!");
    }
}
