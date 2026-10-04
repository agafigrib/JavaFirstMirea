package ru.mirea.task2.zadanie7;

public class BookShelf {

    private Book[] books;
    private int count;

    // Создание полки
    public BookShelf(int size) {
        books = new Book[size];
        count = 0;
    }

    // Добавить книгу
    public void addBook(Book book) {

        if (count < books.length) {
            books[count] = book;
            count++;
        }
    }

    // Показать все книги
    public void showBooks() {

        for (int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }

    // Найти самую старую книгу
    public Book getOldestBook() {

        Book oldest = books[0];

        for (int i = 1; i < count; i++) {

            if (books[i].getAge() < oldest.getAge()) {
                oldest = books[i];
            }
        }

        return oldest;
    }

    // Найти самую новую книгу
    public Book getNewestBook() {

        Book newest = books[0];

        for (int i = 1; i < count; i++) {

            if (books[i].getAge() > newest.getAge()) {
                newest = books[i];
            }
        }

        return newest;
    }

    // Сортировка книг по году
    public void sortBooks() {

        for (int i = 0; i < count - 1; i++) {

            for (int j = 0; j < count - 1 - i; j++) {

                if (books[j].getAge() > books[j + 1].getAge()) {

                    Book temp = books[j];

                    books[j] = books[j + 1];

                    books[j + 1] = temp;
                }
            }
        }
    }
}

