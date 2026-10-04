package ru.mirea.task2.zadanie7;

public class Book {
    private String author;
    private String name;
    private int age;

    public Book (String author, String name, int age) {
        this.author = author;
        this.name = name;
        this.age = age;

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String toString() {
        return "Название книги: " + name +
                ", Автор: " + author +
                ", Дата издания: " + age;
    }
}
