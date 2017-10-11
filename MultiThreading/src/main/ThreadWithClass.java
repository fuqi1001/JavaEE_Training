package main;

public class ThreadWithClass extends Thread{
    @Override
    public void run() {
        System.out.println("ThreadWithClass is running");
        for(int i = 0 ; i < 10; i++){
            System.out.println("ThreadWithClass :" + i);
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
        }
        System.out.println("ThreadWithClass is done");
    }
}
