package ru.mirea.task3;



import java.util.Arrays;
import java.util.Random;

public class zadanie1 {
    public static void main(String[] args) {

        int n = 10;

        // Генерация с помощью Math.random()
        double[] arrayMath = new double[n];

        for (int i = 0; i < n; i++) {
            arrayMath[i] = Math.random() * 100;
        }

        System.out.println("Массив, созданный с помощью Math.random():");
        System.out.println(Arrays.toString(arrayMath));

        Arrays.sort(arrayMath);

        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(arrayMath));


        // Генерация с помощью класса Random
        Random random = new Random();
        double[] arrayRandom = new double[n];

        for (int i = 0; i < n; i++) {
            arrayRandom[i] = random.nextDouble() * 100;
        }

        System.out.println("\nМассив, созданный с помощью Random:");
        System.out.println(Arrays.toString(arrayRandom));

        Arrays.sort(arrayRandom);

        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(arrayRandom));
    }
}