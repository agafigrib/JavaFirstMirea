package ru.mirea.task18;

public class zadanie6 {
    // без обработки: исключение уйдёт выше и программа упадёт
    public void printMessageRaw(String key) {
        String message = getDetails(key);
        System.out.println(message);
    }

    // с обработкой: программа не падает
    public void printMessage(String key) {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (NullPointerException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public String getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        zadanie6 demo = new zadanie6();
        demo.printMessageRaw("abc");
        try {
            demo.printMessageRaw(null);
        } catch (NullPointerException e) {
            System.out.println("Без обработки: " + e);
        }
        demo.printMessage("abc");
        demo.printMessage(null);
    }
}