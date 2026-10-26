package ru.mirea.task11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class zadanie2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        format.setLenient(false);   // отвергаем несуществующие даты вроде 31.02

        System.out.print("Введите дату и время (дд.ММ.гггг чч:мм): ");
        String text = in.nextLine();

        try {
            Date entered = format.parse(text);
            Date now = new Date();   // текущее системное время

            System.out.println("Текущая дата: " + format.format(now));
            System.out.println("Введённая дата: " + format.format(entered));

            if (entered.before(now)) {
                System.out.println("Введённая дата раньше текущей");
            } else if (entered.after(now)) {
                System.out.println("Введённая дата позже текущей");
            } else {
                System.out.println("Даты совпадают");
            }

            long diffMillis = Math.abs(entered.getTime() - now.getTime());
            long days = diffMillis / (1000L * 60 * 60 * 24);
            System.out.println("Разница: " + days + " дн.");
        } catch (ParseException e) {
            System.out.println("Неверный формат даты. Пример: 25.12.2026 18:30");
        }
    }
}