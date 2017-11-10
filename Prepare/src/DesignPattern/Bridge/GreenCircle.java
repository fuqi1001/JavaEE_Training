package DesignPattern.Bridge;

public class GreenCircle  implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Green, "+ radius +" x: " + x +" y: " + y);
    }
}
