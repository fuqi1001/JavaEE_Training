package Interface.MultiThread.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThreadTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for(;i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        return i;
    }

    public static void main(String[] args) {
        CallableThreadTest ctt = new CallableThreadTest();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for(int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+ " loop "+ i);

            if(i == 20) {
                new Thread(ft, "thread with return").start();
            }
        }
        try {
            System.out.println("child thread return: "+ ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
