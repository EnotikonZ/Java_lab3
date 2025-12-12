package ru.semeshko.geometry;

/**
 * Треугольник: три точки.
 */
public class Triangle implements Figure {

    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Площадь по формуле (через определитель)
    public double area() {
        return Math.abs(
                (a.getX() * (b.getY() - c.getY())
                        + b.getX() * (c.getY() - a.getY())
                        + c.getX() * (a.getY() - b.getY())) / 2.0
        );
    }

    public String toString() {
        return "Треугольник(" + a + ", " + b + ", " + c + ")";
    }
}
