package ru.mirea.task1;
import java.util.Scanner;
import java.util.Arrays;

public class Zadanie3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
    int length = sc.nextInt();
    int[] array = new int[length];
    int summ = 0;
    double aver = 0;
    int counter = 0;
        System.out.println("Введите ЦЕЛОЧИСЛЕННЫЕ элементы массива:");
        for (int i = 0; i < length; i++) {
        if (sc.hasNextInt()) {
            array[i] = sc.nextInt();
            summ += array[i];
            counter += 1;
        }
        else {
            System.out.println("Вы ввели не целое число");
        }
        aver = (double) summ / counter;
     }
                System.out.println("Массив: " + Arrays.toString(array));
                System.out.println("Сумма: " + summ);
                System.out.println("Среднее арифметическое: " + aver);
    }
}

