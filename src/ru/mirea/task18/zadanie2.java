package ru.mirea.task18;

import java.util.Scanner;

public class zadanie2 {
    // шаг 2: без обработки (Qwerty и 1.2 - NumberFormatException, 0 - ArithmeticException)
    public void exceptionDemoRaw(Scanner myScanner) {
        System.out.print("Enter an integer ");
        String intString = myScanner.nextLine().trim();
        int i = Integer.parseInt(intString);
        System.out.println(2 / i);
    }

    public void exceptionDemoRaw() {
        exceptionDemoRaw(new Scanner(System.in));
    }

    // шаг 3: каждое исключение ловим своим catch
    public void exceptionDemo(Scanner myScanner) {
        System.out.print("Enter an integer ");
        String intString = myScanner.nextLine().trim();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: \"" + intString + "\" не является целым числом");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль");
        }
    }

    public void exceptionDemo() {
        exceptionDemo(new Scanner(System.in));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        zadanie2 ex = new zadanie2();
        System.out.println("Вводите по очереди: Qwerty, 0, 1.2, 1");
        System.out.println("Без обработки (видно, какое исключение выбрасывается):");
        for (int n = 0; n < 4; n++) {
            try {
                ex.exceptionDemoRaw(sc);
            } catch (Exception e) {
                System.out.println("Выброшено: " + e.getClass().getName() + ": " + e.getMessage());
            }
        }
        System.out.println("С обработкой try-catch (снова: Qwerty, 0, 1.2, 1):");
        for (int n = 0; n < 4; n++) {
            ex.exceptionDemo(sc);
        }
    }
}