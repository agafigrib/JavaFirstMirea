package ru.mirea.task2.zadanie2;

public class Ball {
    private double x = 0.0;
    private double y = 0.0;

    public Ball (double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }
    public void setXY(double X, double Y) {}

    public void move(double xDisp, double yDisp) {}

    public String toString(){
        return "Положение мяча: " + "\n x: " + x + "\n y: " + y; }
}
