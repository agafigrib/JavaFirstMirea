package ru.mirea.task2.zadanie6;

public class Circle {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double length() {
        return 2 * Math.PI * radius;
    }

    public boolean equals(Circle circle) {

        if (radius == circle.radius) {
            return true;
        }

        return false;
    }
}

