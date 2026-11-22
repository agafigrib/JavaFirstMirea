package ru.mirea.task18;

import java.util.Scanner;

public class zadanie3 {
    // catch (Exception e) нельзя ставить первым - он ловит и потомков, будет ошибка компиляции
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
            // общий catch ставим последним
            System.out.println("Прочая ошибка: " + e.getClass().getName());
        }
    }

    public void exceptionDemo() {
        exceptionDemo(new Scanner(System.in));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        zadanie3 ex = new zadanie3();
        System.out.println("Вводите по очереди: Qwerty, 0, 1.2, 1");
        for (int n = 0; n < 4; n++) {
            ex.exceptionDemo(sc);
        }
    }
}