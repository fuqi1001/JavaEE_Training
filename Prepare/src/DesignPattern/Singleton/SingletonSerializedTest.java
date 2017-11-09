package DesignPattern.Singleton;

import java.io.*;

public class SingletonSerializedTest {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        SerializedSingleton i1 = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(i1);
        out.close();

        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        SerializedSingleton i2 = (SerializedSingleton)in.readObject();
        in.close();

        System.out.println("instanceOne hashCode="+i1.hashCode());
        System.out.println("instanceTwo hashCode="+i2.hashCode());

    }
}
