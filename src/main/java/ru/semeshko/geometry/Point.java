package ru.semeshko.geometry;

/**
 * Точка на плоскости.
 * Задание 6.2: equals по координатам.
 * Задание 8.4: clone возвращает новый объект с копиями значений.
 */
public class Point implements Cloneable {

    protected final double x;
    protected final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) return false;
        Point p = (Point) obj;
        return this.x == p.x && this.y == p.y;
    }

    public Point clone() {
        return new Point(x, y);
    }

    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
