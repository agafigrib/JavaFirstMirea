package ru.mirea.task2.zadanie2;

public class Ball {
    private double x = 0.0;
    private double y = 0.0;

    public Ball(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Ball() {             // конструктор без параметров: мяч в точке (0, 0)
    }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    // задать обе координаты сразу
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // сдвинуть мяч на xDisp по x и на yDisp по y
    public void move(double xDisp, double yDisp) {
        x += xDisp;
        y += yDisp;
    }

    public String toString() {
        return "Ball @ (" + x + ", " + y + ")";
    }
}
