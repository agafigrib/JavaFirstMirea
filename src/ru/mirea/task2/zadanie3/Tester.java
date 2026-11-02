package ru.mirea.task2.zadanie3;

public class Tester {

    private Circle[] circles;   // массив окружностей
    private int count;          // сколько окружностей уже добавлено

    public Tester(int size) {
        circles = new Circle[size];
        count = 0;
    }

    public void addCircle(Circle circle) {
        if (count < circles.length) {
            circles[count] = circle;
            count++;
        }
    }

    public void showCircles() {
        for (int i = 0; i < count; i++) {
            System.out.println(circles[i]);
            System.out.println("Площадь: " + circles[i].getArea());
            System.out.println("Длина окружности: " + circles[i].getLength());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Tester tester = new Tester(5);

        tester.addCircle(new Circle(new Point(0, 0), 5));
        tester.addCircle(new Circle(new Point(2, 3), 5));
        tester.addCircle(new Circle(new Point(-1, 4), 2));

        System.out.println("Количество окружностей: " + tester.count);
        System.out.println();
        tester.showCircles();

        System.out.println("Радиусы первой и второй окружностей равны: " +
                tester.circles[0].isEqual(tester.circles[1]));
    }
}
