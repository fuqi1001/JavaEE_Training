package main;

public class ThreadWithInterface implements Runnable{
    @Override
    public void run() {
        System.out.println("ThreadWithInterface 1 is running");
        for(int i = 0 ; i < 10; i++){
            System.out.println("ThreadWithInterface :" + i);
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
        }
        System.out.println("ThreadWithInterface is done");
    }
}
