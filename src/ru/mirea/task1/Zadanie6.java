package ru.mirea.task1;
import java.util.Scanner;

public class Zadanie6 {
    public static void main(String[] args) {
    System.out.print("Введите любое адекватное значение: ");
    Scanner s = new Scanner(System.in);
        System.out.print("Гармонический ряд: ");
    int i = 0;
    float result = 0;
        for (i = 1; i <= 10; i++) {
        result = (float) 1 / i;
        System.out.println();
        System.out.println("Значение № " + i);
        System.out.print(" " + result);
        }
    }
}
