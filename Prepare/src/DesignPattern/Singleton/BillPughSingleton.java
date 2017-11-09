package DesignPattern.Singleton;


/*
too many threads try to get the instance of the Singleton class simultaneously.
create Singleton class using a inner static helper class.
 */
public class BillPughSingleton {

    private BillPughSingleton() {}

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

/*
private inner static class that contains the instance of the singleton class.
when the singleton class is loaded, SingletonHelper class is not loaded into memory
and only when someone calls the getInstance() method, this class gets loaded and
creates the Singleton class instance.
This is the most widely used approach for Singleton class as it doesn’t require synchronization.
 */
