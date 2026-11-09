package ru.mirea.task17;

import java.util.Scanner;

// Элемент картотеки - студент
public class Student {
    private String name;
    private int age;
    private String group;

    public Student() {
    }

    public Student(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    // a. считать атрибуты объекта с консоли
    public void readFromConsole(Scanner sc) {
        System.out.print("Имя: ");
        name = sc.nextLine();
        System.out.print("Возраст: ");
        age = Integer.parseInt(sc.nextLine());
        System.out.print("Группа: ");
        group = sc.nextLine();
    }


    public void print() {
        System.out.println("Имя: " + name + ", возраст: " + age + ", группа: " + group);
    }

    // строка для записи в файл: поля через точку с запятой
    public String toFileLine() {
        return name + ";" + age + ";" + group;
    }

    // создать студента из строки файла
    public static Student fromFileLine(String line) {
        String[] parts = line.split(";");
        return new Student(parts[0], Integer.parseInt(parts[1]), parts[2]);
    }
}