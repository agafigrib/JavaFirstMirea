package ru.mirea.task2.zadanie2;
import java.lang.*;
import java.util.Scanner;

public class TestBall {
    public static void main(String[] args) {
        double x;
        double y;
        double xDisp;
        double yDisp;
        Ball k1 = new Ball (0.0, 0.0);
        System.out.println("Положение мяча: " + "\n x: " + k1.getX() + "\n y: " + k1.getY());

        Scanner source = new Scanner(System.in);
        System.out.println("Введите новый x: ");
        xDisp = source.nextDouble();
        k1.setX(xDisp);
        System.out.println("Введите новый y: ");
        yDisp = source.nextDouble();
        k1.setY(yDisp);
        System.out.println("Положение мяча: " + "\n x: " + k1.getX() + "\n y: " + k1.getY());
    }
}
