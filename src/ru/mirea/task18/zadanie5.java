package ru.mirea.task18;

public class zadanie5 {
    // шаг 1: выбрасываем исключение, если ключ null
    public void getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
    }

    // шаг 2: ловим исключение прямо в методе
    public void getDetailsHandled(String key) {
        try {
            if (key == null) {
                throw new NullPointerException("null key in getDetails");
            }
        } catch (NullPointerException e) {
            System.out.println("Перехвачено внутри метода: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        zadanie5 demo = new zadanie5();
        try {
            demo.getDetails(null);
        } catch (NullPointerException e) {
            System.out.println("Шаг 1: " + e);
        }
        System.out.println("Шаг 2:");
        demo.getDetailsHandled(null);
    }
}