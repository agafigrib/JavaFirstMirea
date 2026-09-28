package ru.mirea.task2.zadanie1;
import java.util.Scanner;
import java.lang.*;

public class TestAuthor {
    public static void main(String[] args) {
        String email;
        Author k1 = new Author("Andrey", "endy.07@mail.ru", 'М');
        System.out.println("Имя автора - " + k1.getName() + " " + "Пол - " + k1.getGender() + " " + "Email - " + k1.getEmail());
        Scanner source = new Scanner(System.in);
        System.out.println("Введите почту: ");
        email = source.next();
        k1.setEmail(email);
        System.out.println("Имя автора - " + k1.getName() + " " + "Пол - " + k1.getGender() + "Email - " + k1.getEmail());
    }
}

// тут происходит замена адреса электронной почты с endy.07@mail.ru на введенный с клавиатуры
