package ru.semeshko.geometry;

/**
 * Прямоугольник: левый верхний угол + стороны.
 */
public class Rectangle implements Figure {

    private final Point topLeft;
    private final double width;
    private final double height;

    public Rectangle(Point topLeft, double width, double height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public String toString() {
        return "Прямоугольник(лев.верх=" + topLeft + ", w=" + width + ", h=" + height + ")";
    }
}
