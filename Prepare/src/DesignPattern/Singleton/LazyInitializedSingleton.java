package DesignPattern.Singleton;

public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton() {}

    public static LazyInitializedSingleton getInstance() {
        if(instance == null) {
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
/*
Lazy initialization method to implement Singleton pattern creates the instance in the global access method. 
The above implementation works fine incase of single threaded environment
but when it comes to multithreaded systems,
it can cause issues if multiple threads are inside the if loop at the same time.
It will destroy the singleton pattern and both threads will get the different instances of singleton class. 
 */
/*
这段代码简单明了，而且使用了懒加载模式，但是却存在致命的问题。当有多个线程并行调用 getInstance() 的时候，就会创建多个实例。也就是说在多线程下不能正常工作。
 */

class LazyInitializedSingletonThreadSafe {
    private static LazyInitializedSingletonThreadSafe instance;

    private LazyInitializedSingletonThreadSafe(){}
    public static synchronized LazyInitializedSingletonThreadSafe getInstance() {
        if(instance == null) {
            instance = new LazyInitializedSingletonThreadSafe();
        }
        return instance;
    }
}
/*
虽然做到了线程安全，并且解决了多实例的问题，但是它并不高效。因为在任何时候只能有一个线程调用 getInstance() 方法。
但是同步操作只需要在第一次调用时才被需要，即第一次创建单例实例对象时。这就引出了双重检验锁。
 */


class LazySingletonThreadSafe {
    private volatile static LazySingletonThreadSafe instance;

    private LazySingletonThreadSafe(){}

    public static LazySingletonThreadSafe getSingleton() {
        if(instance == null) {
            synchronized (LazySingletonThreadSafe.class) {
                if(instance == null) {
                    instance = new LazySingletonThreadSafe();
                }
            }
        }
        return instance;
    }
}

/*
双重检验锁模式（double checked locking pattern），
是一种使用同步块加锁的方法。程序员称其为双重检查锁，因为会有两次检查 instance == null，
一次是在同步块外，一次是在同步块内。为什么在同步块内还要再检验一次？
因为可能会有多个线程一起进入同步块外的 if，如果在同步块内不进行二次检验的话就会生成多个实例了。

使用 volatile 的主要原因是其另一个特性：禁止指令重排序优化
volatile 的原因是可见性，也就是可以保证线程在本地不会存有 instance 的副本，每次都是去主内存中读取。
 */