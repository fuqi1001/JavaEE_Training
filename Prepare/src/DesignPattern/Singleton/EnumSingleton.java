package DesignPattern.Singleton;

public enum EnumSingleton {
    INSTANCE;
    private EnumSingleton() {
        System.out.println("Here");
    }

    public static void main(String[] args) {
        System.out.println(EnumSingleton.INSTANCE);

    }
}
