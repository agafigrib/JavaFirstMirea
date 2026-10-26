package ru.mirea.task8;

import java.util.Scanner;

public class zadanie10 {
    // result накапливает перевёрнутое число
    public static int reverse(int n, int result) {
        if (n == 0) {
            return result;
        }
        return reverse(n / 10, result * 10 + n % 10);   // шаг рекурсии
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(reverse(n, 0));
    }
}