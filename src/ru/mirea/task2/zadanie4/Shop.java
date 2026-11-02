package ru.mirea.task2.zadanie4;
import java.util.ArrayList;

public class Shop {
    // показать все компьютеры
    public static void Computers(ArrayList<String> PC) {
        if (PC.isEmpty()) {
            System.out.println("В магазине нет компьютеров");
            return;
        }
        for (int i = 0; i < PC.size(); i++) {
            System.out.println(i + ": " + PC.get(i));
        }
    }

    public static ArrayList<String> ComputerAdd(ArrayList<String> PC, String computer) {
        PC.add(computer);
        return PC;
    }

    public static ArrayList<String> ComputerDelete(ArrayList<String> PC, String computer) {
        PC.remove(computer);
        return PC;
    }

    // поиск по названию: если не нашли, indexOf вернёт -1
    public static String ComputerSearchName(ArrayList<String> PC, String search) {
        int index = PC.indexOf(search);
        if (index == -1) {
            System.out.println("Компьютер \"" + search + "\" не найден");
            return null;
        }
        System.out.println("Найден под номером " + index + ": " + PC.get(index));
        return PC.get(index);
    }

    // поиск по номеру: проверяем, что номер существует
    public static String ComputerSearchIndex(ArrayList<String> PC, int index) {
        if (index < 0 || index >= PC.size()) {
            System.out.println("Нет компьютера с номером " + index);
            return null;
        }
        System.out.println("Компьютер №" + index + ": " + PC.get(index));
        return PC.get(index);
    }
}
