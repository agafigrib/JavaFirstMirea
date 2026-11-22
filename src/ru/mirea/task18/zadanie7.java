package ru.mirea.task18;

import java.util.Scanner;

public class zadanie7 {
    // throws нужен у всех методов цепочки, иначе ошибка unreported exception
    public void getKey(Scanner myScanner) throws Exception {
        String key = myScanner.nextLine();
        printDetails(key);
    }

    public void getKey() throws Exception {
        getKey(new Scanner(System.in));
    }

    public void printDetails(String key) throws Exception {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (Exception e) {
            // пробрасываем исключение дальше
            throw e;
        }
    }

    private String getDetails(String key) throws Exception {
        // строки сравниваем через isEmpty(), а не ==
        if (key.isEmpty()) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        System.out.println("Введите пустую строку, чтобы вызвать исключение, или любой ключ");
        zadanie7 demo = new zadanie7();
        try {
            demo.getKey();
        } catch (Exception e) {
            System.out.println("Исключение дошло до main: " + e.getMessage());
        }
    }
}