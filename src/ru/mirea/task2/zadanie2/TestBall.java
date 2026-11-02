package ru.mirea.task2.zadanie2;
import java.util.Scanner;

public class TestBall {
    public static void main(String[] args) {
        Ball ball = new Ball(0.0, 0.0);
        System.out.println(ball);

        Scanner source = new Scanner(System.in);
        System.out.println("На сколько сдвинуть по x: ");
        double xDisp = source.nextDouble();
        System.out.println("На сколько сдвинуть по y: ");
        double yDisp = source.nextDouble();

        ball.move(xDisp, yDisp);          // сдвигаем
        System.out.println("После move: " + ball);

        ball.setXY(10, 20);               // ставим в точку (10, 20)
        System.out.println("После setXY(10, 20): " + ball);
    }
}

