package main.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("a");
        strList.add("b");
        strList.add("c");

        Lock lock = new ReentrantLock();
        new ThreadRead(strList, "Thread1", lock).start();
        new ThreadRead(strList, "Thread2", lock).start();
    }
}
