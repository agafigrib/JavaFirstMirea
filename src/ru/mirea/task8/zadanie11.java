package ru.mirea.task8;

import java.util.Scanner;

public class zadanie11 {
    static Scanner in = new Scanner(System.in);


    public static int countOnes() {
        int x = in.nextInt();
        if (x == 0) {
            int y = in.nextInt();
            if (y == 0) {
                return 0;
            }
            return (y == 1 ? 1 : 0) + countOnes();
        }
        return (x == 1 ? 1 : 0) + countOnes(); // шаг рекурсии
    }

    public static void main(String[] args) {
        System.out.println(countOnes());
    }
}