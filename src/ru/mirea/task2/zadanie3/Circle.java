package ru.mirea.task2.zadanie3;

public class Circle  {

    private double x;
    private double y;
    private double radius;

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getLength() {
        return 2 * Math.PI * radius;
    }

    public boolean isEqual(Circle other) {

        return other != null &&
                Double.compare(
                        radius,
                        other.radius
                ) == 0;
    }

    @Override
    public String toString() {
        return "Circle[x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                "]";
    }
}

