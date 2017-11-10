package DesignPattern.Facade;

public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker sm = new ShapeMaker();

        sm.drawCircle();
        sm.drawRectangle();
        sm.drawSqure();
    }
}
