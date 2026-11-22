package ru.mirea.task18;

import java.util.Scanner;

public class zadanie4 {
    public void exceptionDemo(Scanner myScanner) {
        System.out.print("Enter an integer ");
        try {
            String intString = myScanner.nextLine().trim();
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введено не целое число");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль");
        } catch (Exception e) {
            System.out.println("Прочая ошибка: " + e.getClass().getName());
        } finally {
            // finally выполняется всегда, и с ошибкой, и без неё
            System.out.println("Блок finally выполнен");
        }
    }

    public void exceptionDemo() {
        exceptionDemo(new Scanner(System.in));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        zadanie4 ex = new zadanie4();
        System.out.println("Вводите по очереди: Qwerty, 0, 1.2, 1");
        for (int n = 0; n < 4; n++) {
            ex.exceptionDemo(sc);
        }
    }
}