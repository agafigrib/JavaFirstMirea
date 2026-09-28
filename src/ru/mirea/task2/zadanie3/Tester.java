package ru.mirea.task2.zadanie3;

public class Tester  {

    public static void main(String[] args) {

        Circle c1 =
                new Circle(0, 0, 5);

        Circle c2 =
                new Circle(2, 3, 5);

        System.out.println(c1);

        System.out.println(
                "Площадь: " +
                        c1.getArea()
        );

        System.out.println(
                "Длина окружности: " +
                        c1.getLength()
        );

        System.out.println(
                "Радиусы окружностей равны: " +
                        c1.isEqual(c2)
        );
    }
}
