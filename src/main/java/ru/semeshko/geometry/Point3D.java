package ru.semeshko.geometry;

/**
 * Задание 3.5: Трёхмерная точка (X, Y, Z).
 */
public class Point3D extends Point {

    private final double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() { return z; }

    public String toString() {
        return "{" + x + ";" + y + ";" + z + "}";
    }
}
