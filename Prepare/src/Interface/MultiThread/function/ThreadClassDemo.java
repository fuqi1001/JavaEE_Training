package Interface.MultiThread.function;

public class ThreadClassDemo {
    public static void main(String[] args) {
        Runnable hello = new DisplayMessage("Hello!");
        Thread thread1 = new Thread(hello);
        thread1.setDaemon(true);  //将该线程标记为守护线程或用户线程。
        //thread1.setName( "hello thread1");
        System.out.println(thread1.getName()+" Starting hello thread1...");
        thread1.start();

        Runnable bye = new DisplayMessage("Bye!");
        Thread thread2 = new Thread(bye);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.setDaemon(true);
        System.out.println(thread2.getName()+ " Starting goodbye thread2");
        thread2.start();

        System.out.println("Starting thread3...");
        Thread thread3 = new GuessANumber(27);
        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted. ");
        }
        System.out.println("Starting thread4...");
        Thread thread4 = new GuessANumber(75);

        thread4.start();
        System.out.println("main() is ending");
    }
}
