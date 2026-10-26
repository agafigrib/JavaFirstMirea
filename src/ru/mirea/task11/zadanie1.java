package ru.mirea.task11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class zadanie1 {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        // дату получения задания впишите свою (формат дд.ММ.гггг чч:мм:сс)
        String receivedAt = "26.10.2026 10:00:00";

        Date submittedAt = new Date();   // текущие дата и время сдачи

        System.out.println("Разработчик: Иванов");   // впишите свою фамилию
        System.out.println("Дата и время получения задания: " + receivedAt);
        System.out.println("Дата и время сдачи задания: " + format.format(submittedAt));
    }
}
