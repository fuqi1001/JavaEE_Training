package DesignPattern.Singleton;


/*
*In eager initialization,
*the instance of Singleton Class is created at the time of class loading,
*this is the easiest method to create a singleton class
*but it has a drawback that instance is created even though
*client application might not be using it.
*/
public class EagerInitializedSingleton {
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    //private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance(){
        return instance;
    }

}

/*
If your singleton class is not using a lot of resources,
this is the approach to use. But in most of the scenarios,
Singleton classes are created for resources such as File System,
Database connections etc and we should avoid the instantiation
until unless client calls the getInstance method.
Also this method doesn’t provide any options for exception handling.
譬如 Singleton 实例的创建是依赖参数或者配置文件的，
在 getInstance() 之前必须调用某个方法设置参数给它，
那样这种单例写法就无法使用了。
 */