package DesignPattern.Decorator;

public class SimpleWindow implements Window {
    @Override
    public void draw() {
        System.out.println("Draw window");
    }

    @Override
    public String getDescription() {
        return "Simple window";
    }
}
