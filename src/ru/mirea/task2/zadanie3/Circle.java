package ru.mirea.task2.zadanie3;

public class Circle {

    private Point center;    // центр окружности - объект класса Point
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
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
        return other != null && Double.compare(radius, other.radius) == 0;
    }

    @Override
    public String toString() {
        return "Circle[центр=(" + center.getX() + ", " + center.getY() +
                "), radius=" + radius + "]";
    }
}
