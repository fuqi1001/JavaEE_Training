package main.java.antra.springDemo.service2;

import main.java.antra.springDemo.model.Circle;
import main.java.antra.springDemo.model.Triangle;


public class ShapeService {
    private Circle circle;
    private Triangle triangle;

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }

    public Circle getCircle() {

        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
}
