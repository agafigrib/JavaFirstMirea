package ru.mirea.task2.zadanie8;

public class Revers {

    public static void main(String[] args) {

        String[] array = {
                "A", "B", "C", "D", "E"
        };

        for (int i = 0; i < array.length / 2; i++) {

            String temp = array[i];
            array[i] = array[array.length - 1 - i];

            array[array.length - 1 - i] = temp;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println("Элемент № " + i + " = " + array[i]);
        }
    }
}