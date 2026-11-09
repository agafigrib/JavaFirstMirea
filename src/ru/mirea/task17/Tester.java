package ru.mirea.task17;

import java.io.IOException;
import java.util.Scanner;

// Класс Тестер: текстовое меню для всех функций списка
public class Tester {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Выберите структуру данных:");
        System.out.println("1 - односвязный список");
        System.out.println("2 - двусвязный список");
        System.out.println("3 - кольцевой список");
        System.out.print("> ");
        String type = sc.nextLine().trim();

        // переменная типа интерфейса - подходит любой из трёх списков
        StudentList list;
        if (type.equals("2")) {
            list = new DoublyLinkedList();
        } else if (type.equals("3")) {
            list = new CircularList();
        } else {
            list = new SinglyLinkedList();
        }
        System.out.println("Создан пустой список: " + list.getClass().getSimpleName());

        while (true) {
            System.out.println();
            System.out.println("1 - добавить студента");
            System.out.println("2 - удалить студента по номеру");
            System.out.println("3 - вывести студента по номеру");
            System.out.println("4 - вывести весь список");
            System.out.println("5 - очистить список");
            System.out.println("6 - проверить, пуст ли список");
            System.out.println("7 - записать список в файл");
            System.out.println("8 - прочитать список из файла");
            System.out.println("0 - выход");
            System.out.print("> ");
            String choice = sc.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        Student s = new Student();
                        s.readFromConsole(sc);
                        list.add(s);
                        System.out.println("Добавлено. Всего: " + list.size());
                        break;
                    case "2":
                        System.out.print("Номер: ");
                        int del = Integer.parseInt(sc.nextLine().trim());
                        if (list.remove(del)) {
                            System.out.println("Удалено");
                        } else {
                            System.out.println("Нет элемента с номером " + del);
                        }
                        break;
                    case "3":
                        System.out.print("Номер: ");
                        list.printElement(Integer.parseInt(sc.nextLine().trim()));
                        break;
                    case "4":
                        list.printAll();
                        break;
                    case "5":
                        list.clear();
                        System.out.println("Список очищен");
                        break;
                    case "6":
                        System.out.println(list.isEmpty() ? "Список пуст" : "В списке " + list.size() + " эл.");
                        break;
                    case "7":
                        System.out.print("Имя файла: ");
                        list.saveToFile(sc.nextLine().trim());
                        System.out.println("Сохранено");
                        break;
                    case "8":
                        System.out.print("Имя файла: ");
                        list.loadFromFile(sc.nextLine().trim());
                        System.out.println("Загружено элементов: " + list.size());
                        break;
                    case "0":
                        System.out.println("Выход");
                        return;
                    default:
                        System.out.println("Нет такого пункта");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: нужно ввести число");
            } catch (IOException e) {
                System.out.println("Ошибка работы с файлом: " + e.getMessage());
            }
        }
    }
}