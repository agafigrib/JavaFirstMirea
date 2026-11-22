package ru.mirea.task20;

public class Calculator {
    private Calculator() {
    }

    // методы принимают два числа разных типов
    public static <T extends Number, V extends Number> double sum(T a, V b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number, V extends Number> double multiply(T a, V b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <T extends Number, V extends Number> double divide(T a, V b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return a.doubleValue() / b.doubleValue();
    }

    public static <T extends Number, V extends Number> double subtraction(T a, V b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println("sum(5, 2.5) = " + sum(5, 2.5));
        System.out.println("multiply(4, 2.5) = " + multiply(4, 2.5));
        System.out.println("divide(10L, 4) = " + divide(10L, 4));
        System.out.println("subtraction(1.5, 3) = " + subtraction(1.5, 3));
        try {
            divide(1, 0);
        } catch (ArithmeticException e) {
            System.out.println("divide(1, 0): " + e.getMessage());
        }
    }
}