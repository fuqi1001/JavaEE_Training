package DesignPattern.Decorator;

public class Main {
    static void printInfo(Window w) {
        System.out.println("Description: " + w.getDescription());
    }

    public static void main(String[] args) {
        SimpleWindow sw = new SimpleWindow();
        printInfo(sw);

        HorizontalScrollBar hbw = new HorizontalScrollBar(sw);
        printInfo(hbw);

        VerticalScrollBar vbw = new VerticalScrollBar(hbw);
        printInfo(vbw);
    }
}

/*
In object-oriented programming,
the decorator pattern is a design pattern that allows behavior
to be added to an individual object,
either statically or dynamically,
without affecting the behavior of other objects from the same class.
The decorator pattern is often useful for adhering
to the Single Responsibility Principle,
as it allows functionality to be divided between classes with unique areas of concern
 */