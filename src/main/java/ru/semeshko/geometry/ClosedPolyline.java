package ru.semeshko.geometry;

/**
 * Замкнутая ломаная: последняя точка совпадает с первой.
 */
public class ClosedPolyline extends Polyline {

    public ClosedPolyline(Point[] points) {
        super(points);
        // Предполагаем, что замыкание обеспечено тем, кто создаёт.
    }

    public String toString() {
        return "Замкнутая ломаная: " + java.util.Arrays.toString(points);
    }
}
