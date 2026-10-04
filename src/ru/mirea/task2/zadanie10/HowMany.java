package ru.mirea.task2.zadanie10;

import java.util.Scanner;

public class HowMany {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите слова:");

        String text = scanner.nextLine();

        String[] words = text.split(" ");

        System.out.println("Количество слов: " + words.length);
    }
}
