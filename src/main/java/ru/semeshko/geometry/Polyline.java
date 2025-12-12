package ru.semeshko.geometry;

import java.util.Arrays;

/**
 * Ломаная линия — массив точек.
 */
public class Polyline {

    protected final Point[] points;

    public Polyline(Point[] points) {
        this.points = Arrays.copyOf(points, points.length);
    }

    public Point[] getPoints() {
        return Arrays.copyOf(points, points.length);
    }

    public String toString() {
        return "Ломаная: " + Arrays.toString(points);
    }
}
