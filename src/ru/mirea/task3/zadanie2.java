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

    public String toString() {
        return "Центр: (" + center.x + ", " + center.y + "), радиус: " + radius;
    }
}

public class zadanie2 {

    // самая маленькая окружность
    static Circle findMin(Circle[] circles) {
        Circle min = circles[0];
        for (int i = 1; i < circles.length; i++) {
            if (circles[i].radius < min.radius) {
                min = circles[i];
            }
        }
        return min;
    }

    // самая большая окружность
    static Circle findMax(Circle[] circles) {
        Circle max = circles[0];
        for (int i = 1; i < circles.length; i++) {
            if (circles[i].radius > max.radius) {
                max = circles[i];
            }
        }
        return max;
    }

    // упорядочивание окружностей по радиусу (сортировка пузырьком)
    static void sortCircles(Circle[] circles) {
        for (int i = 0; i < circles.length - 1; i++) {
            for (int j = 0; j < circles.length - 1 - i; j++) {
                if (circles[j].radius > circles[j + 1].radius) {
                    Circle temp = circles[j];
                    circles[j] = circles[j + 1];
                    circles[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        Random random = new Random();

        Circle[] circles = new Circle[5];

        for (int i = 0; i < 5; i++) {
            Point point = new Point(random.nextInt(10), random.nextInt(10));
            double radius = random.nextInt(10) + 1;
            circles[i] = new Circle(point, radius);
        }

        System.out.println("Окружности:");
        for (int i = 0; i < circles.length; i++) {
            System.out.println(circles[i]);
        }

        System.out.println("\nСамая маленькая окружность:");
        System.out.println(findMin(circles));

        System.out.println("\nСамая большая окружность:");
        System.out.println(findMax(circles));

        sortCircles(circles);

        System.out.println("\nОкружности по возрастанию радиуса:");
        for (int i = 0; i < circles.length; i++) {
            System.out.println(circles[i]);
        }
    }
}
