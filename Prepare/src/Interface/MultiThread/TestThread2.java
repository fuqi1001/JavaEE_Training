package Interface.MultiThread;

public class TestThread2 {
    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo("Thread-1");
        t1.start();

        ThreadDemo t2 = new ThreadDemo("Thread-2");
        t2.start();
    }
}
