package ru.mirea.task1;
import java.util.Scanner;

public class Zadanie7 {
    // Метод для вычисления факториала
    public static long factorial(int n) {
    long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        // Проверка работы метода
        if (number >= 0) {
            System.out.println("Факториал числа " + number + " = " + factorial(number));
        }
        else {
            System.out.println("Факториал отрицательного числа не определен.");
        }
        scanner.close();
    }
}

