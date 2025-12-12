package ru.semeshko.geometry;

/**
 * Круг: центр и радиус.
 */
public class Circle implements Figure {

    private final Point center;
    private final double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public String toString() {
        return "Круг(центр=" + center + ", r=" + radius + ")";
    }
}
