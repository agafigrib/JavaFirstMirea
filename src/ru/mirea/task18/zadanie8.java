package ru.mirea.task18;

import java.util.Scanner;

public class zadanie8 {
    // throws убрали, ошибку ловим тут и просим ввести ключ ещё раз
    public void getKey(Scanner myScanner) {
        boolean done = false;
        while (!done) {
            System.out.print("Введите ключ: ");
            String key = myScanner.nextLine();
            try {
                printDetails(key);
                done = true;
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage() + ". Попробуйте ещё раз.");
            }
        }
    }

    public void getKey() {
        getKey(new Scanner(System.in));
    }

    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println(message);
    }

    private String getDetails(String key) throws Exception {
        if (key.isEmpty()) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        new zadanie8().getKey();
    }
}