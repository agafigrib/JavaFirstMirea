package ru.mirea.task19;

import java.util.Scanner;

public class LabClassUI {
    private final LabClass labClass = new LabClass();
    private final Scanner scanner;
    private boolean running = true;

    private final String[] titles;
    // массив интерфейсных ссылок на пункты меню
    private final MenuAction[] actions;

    public LabClassUI(Scanner scanner) {
        this.scanner = scanner;
        this.titles = new String[]{
                "Добавить студента",
                "Показать всех студентов",
                "Отсортировать по среднему баллу",
                "Найти студента по ФИО",
                "Выход"
        };
        this.actions = new MenuAction[]{
                this::addStudent,
                this::showAll,
                this::sort,
                this::find,
                () -> running = false
        };
    }

    // главный цикл меню
    public void run() {
        while (running) {
            printMenu();
            String line = scanner.hasNextLine() ? scanner.nextLine().trim() : "5";
            try {
                int choice = Integer.parseInt(line);
                if (choice < 1 || choice > actions.length) {
                    System.out.println("Нет такого пункта меню");
                } else {
                    actions[choice - 1].execute();
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите номер пункта меню числом");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- Меню ---");
        for (int i = 0; i < titles.length; i++) {
            System.out.println((i + 1) + ". " + titles[i]);
        }
        System.out.print("Ваш выбор: ");
    }

    private void addStudent() {
        System.out.print("ФИО: ");
        String name = scanner.nextLine();
        System.out.print("Средний балл (0-5): ");
        String markText = scanner.nextLine().trim().replace(',', '.');
        try {
            double mark = Double.parseDouble(markText);
            labClass.add(new Student(name, mark));
            System.out.println("Студент добавлен");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: средний балл должен быть числом");
        } catch (EmptyStringException | IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private void showAll() {
        if (labClass.size() == 0) {
            System.out.println("Список пуст");
            return;
        }
        for (StudentInfo s : labClass.getStudents()) {
            System.out.println(s);
        }
    }

    private void sort() {
        labClass.sortByAverageMark();
        System.out.println("Отсортировано по среднему баллу (по убыванию)");
        showAll();
    }

    private void find() {
        System.out.print("Введите ФИО для поиска: ");
        String name = scanner.nextLine();
        try {
            StudentInfo s = labClass.findByFullName(name);
            System.out.println("Найден: " + s);
        } catch (StudentNotFoundException e) {
            System.out.println("Собственное исключение StudentNotFoundException: " + e.getMessage());
        } catch (EmptyStringException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}