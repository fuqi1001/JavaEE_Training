package Concurrent.ConsumerProducer;

public interface Model {
    Runnable newRunnableConsumer();
    Runnable newRunnableProducer();
}
