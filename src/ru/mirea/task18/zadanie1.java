package ru.mirea.task18;

public class zadanie1 {
    // шаг 1: деление int на 0 - будет ArithmeticException
    public void exceptionDemoStep1() {
        System.out.println(2 / 0);
    }

    // шаг 2: с double исключения нет, получится Infinity
    public void exceptionDemoStep2() {
        System.out.println(2.0 / 0.0);
    }

    // шаг 3: ловим исключение через try-catch
    public void exceptionDemo() {
        try {
            System.out.println(2 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
    }

    public static void main(String[] args) {
        zadanie1 ex = new zadanie1();
        try {
            // без try-catch программа бы упала
            ex.exceptionDemoStep1();
        } catch (ArithmeticException e) {
            System.out.println("Шаг 1: " + e);
        }
        System.out.print("Шаг 2 (2.0 / 0.0): ");
        ex.exceptionDemoStep2();
        System.out.print("Шаг 3 (try-catch): ");
        ex.exceptionDemo();
    }
}