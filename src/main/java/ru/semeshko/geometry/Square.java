package ru.semeshko.geometry;

/**
 * Квадрат.
 * Задание 5.6: возвращает замкнутую ломаную (A->B->C->D->A).
 */
public class Square implements Figure {

    private final Point topLeft;
    private final double side;

    public Square(Point topLeft, double side) {
        this.topLeft = topLeft;
        this.side = side;
    }

    public double area() {
        return side * side;
    }

    /**
     * Возвращает замкнутую ломаную квадрата.
     */
    public ClosedPolyline getPolyline() {
        Point a = topLeft;
        Point b = new Point(topLeft.getX() + side, topLeft.getY());
        Point c = new Point(topLeft.getX() + side, topLeft.getY() - side);
        Point d = new Point(topLeft.getX(), topLeft.getY() - side);
        return new ClosedPolyline(new Point[]{a, b, c, d, a});
    }

    public String toString() {
        return "Квадрат(лев.верх=" + topLeft + ", a=" + side + ")";
    }
}
