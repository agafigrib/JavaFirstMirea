package ru.mirea.task1;
import java.util.Scanner;
import java.util.Arrays;

public class Zadanie4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int length = sc.nextInt();
        int[] array = new int[length];

        System.out.println("Введите ЦЕЛОЧИСЛЕННЫЕ элементы массива:");
        // ввод и сумма - цикл do while
        int summ = 0;
        int i = 0;
        do {
            array[i] = sc.nextInt();
            summ += array[i];
            i++;
        } while (i < length);

        // поиск min и max - цикл while
        // начинаем с первого элемента, а не с 0, иначе ошибка на отрицательных числах
        int min = array[0];
        int max = array[0];
        int j = 1;
        while (j < length) {
            if (array[j] < min) min = array[j];
            if (array[j] > max) max = array[j];
            j++;
        }

        System.out.println("Массив: " + Arrays.toString(array));
        System.out.println("Сумма: " + summ);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
    }
}