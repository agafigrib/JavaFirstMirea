package ru.mirea.task2.zadanie7;

import java.util.Scanner;


import java.util.Scanner;

public class BookTest {

    public static void main(String[] args) {

        Book a1 = new Book(
                "Пушкин",
                "Евгений Онегин",
                1831
        );

        Book a2 = new Book(
                "Толстой",
                "Война и мир",
                1869
        );

        Book a3 = new Book(
                "Достоевский",
                "Преступление и наказание",
                1866
        );

        // Создаем полку на 3 книги
        BookShelf shelf = new BookShelf(3);

        // Добавляем книги на полку
        shelf.addBook(a1);
        shelf.addBook(a2);
        shelf.addBook(a3);

        System.out.println("Все книги:");
        shelf.showBooks();

        System.out.println();

        System.out.println("Самая старая книга:");
        System.out.println(shelf.getOldestBook());

        System.out.println();

        System.out.println("Самая новая книга:");
        System.out.println(shelf.getNewestBook());

        System.out.println();

        // Сортируем книги
        shelf.sortBooks();

        System.out.println("Книги после сортировки:");
        shelf.showBooks();
    }
}