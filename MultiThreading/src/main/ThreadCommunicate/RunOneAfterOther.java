package main.ThreadCommunicate;


public class RunOneAfterOther {
    //假设有两个线程，一个是线程 A，另一个是线程 B，两个线程分别依次打印 1-3 三个数字即可。我们来看下代码
    private static void demo1() {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A");
            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("B");
            }
        });

        A.start();
        B.start();
    }
    //那么，如果我们希望 B 在 A 全部打印 完后再开始打印呢？我们可以利用 thread.join() 方法，代码如下:
    private static void demo2() {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A");
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B 开始等待 A");
                try {
                    A.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printNumber("B");
            }
        });
        B.start();
        A.start();
    }

    private static void printNumber(String threadName) {
        int i = 0;
        while(i++ < 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " Print: "+ i);
        }
    }

    public static void main(String[] args) {
        //demo1();
        demo2();
    }
}
