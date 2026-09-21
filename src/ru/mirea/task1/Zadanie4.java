package ru.mirea.task1;
v
import java.util.Arrays;

public class Zadanie4 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
    int length = sc.nextInt();
    int[] array = new int[length];
    int summ = 0;
    int i = 0;
    int min = 2147483647; // максимально возможное int значение -> скорее всего вы введете значение поменьше ;)
    int max = 0;
        System.out.println("Введите ЦЕЛОЧИСЛЕННЫЕ элементы массива:");
            do {
        array[i] = sc.nextInt();
        summ += array[i];
        if (min > array[i]) min = array[i];
        if (max < array[i]) max = array[i];
        i++;
        }
            while (i < length);
        System.out.println("Массив: " + Arrays.toString(array));
        System.out.println("Сумма: " + summ);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
    }
}
