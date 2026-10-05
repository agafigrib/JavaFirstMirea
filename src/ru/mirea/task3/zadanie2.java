package ru.mirea.task3;

import java.util.Random;

class Point {
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Circle {
    Point center;
    double radius;

    Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }
}

public class zadanie2 {
    public static void main(String[] args) {

        Random random = new Random();

        Circle[] circles = new Circle[5];


        for (int i = 0; i < 5; i++) {

            Point point = new Point(
                    random.nextInt(10),
                    random.nextInt(10)
            );

            double radius = random.nextInt(10) + 1;

            circles[i] = new Circle(point, radius);
        }


        System.out.println("Окружности:");

        for (int i = 0; i < 5; i++) {
            System.out.println(
                    "Центр: (" + circles[i].center.x +
                            ", " + circles[i].center.y +
                            "), радиус: " + circles[i].radius
            );
        }


        Circle min = circles[0];

        for (int i = 1; i < 5; i++) {
            if (circles[i].radius < min.radius) {
                min = circles[i];
            }
        }

        Circle max = circles[0];

        for (int i = 1; i < 5; i++) {
            if (circles[i].radius > max.radius) {
                max = circles[i];
            }
        }

        System.out.println("\nСамая маленькая окружность:");
        System.out.println("Радиус = " + min.radius);

        System.out.println("\nСамая большая окружность:");
        System.out.println("Радиус = " + max.radius);
    }
}
