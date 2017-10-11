package main.lock;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class ThreadRead extends Thread{
    List<String> strList = null;
    Lock lock;
    public ThreadRead(List<String> strList, String name, Lock lock) {
        this.strList = strList;
        this.setName(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        go();
        lock.unlock();
    }

    private void go() {
        for(String str : strList) {
            System.out.println(this.getName() + " " + str+", ");
        }
    }
}
