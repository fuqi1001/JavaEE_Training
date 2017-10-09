package Interface.MultiThread.function;

public class DisplayMessage implements Runnable{
    private String message;

    public DisplayMessage(String message) {
        this.message = message;
    }
    @Override
    public void run() {
        try {
            while(true) {
                System.out.println(message);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("end");
        }

        /*while(true) {
            System.out.println(message);
            //Thread.sleep(500);
        }*/

    }
}
