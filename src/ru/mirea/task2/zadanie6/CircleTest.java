package ru.mirea.task2.zadanie6;

public class CircleTest {

    public static void main(String[] args) {

        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(5);

        System.out.println("Радиус: " + circle1.getRadius());

        System.out.println("Площадь: " + circle1.area());

        System.out.println("Длина: " + circle1.length());

        if (circle1.equals(circle2)) {
            System.out.println("Окружности одинаковые");
        } else {
            System.out.println("Окружности разные");
        }
    }
}

