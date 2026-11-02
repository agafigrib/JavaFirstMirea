package ru.mirea.task1;

public class Zadanie5 {
    public static void main(String[] args) {
        System.out.println("Количество аргументов: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("Аргумент " + i + ": " + args[i]);
        }
    }
}
