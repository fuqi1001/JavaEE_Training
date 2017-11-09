package Concurrent.ConsumerProducer;

abstract class AbstractConsumer implements Consumer, Runnable{
    @Override
    public void run() {
        while(true) {
            try {
                consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
