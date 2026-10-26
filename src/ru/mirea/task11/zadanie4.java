package ru.mirea.task11;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class zadanie4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Год: ");
        int year = in.nextInt();
        System.out.print("Месяц (1-12): ");
        int month = in.nextInt();
        System.out.print("Число: ");
        int day = in.nextInt();
        System.out.print("Часы: ");
        int hours = in.nextInt();
        System.out.print("Минуты: ");
        int minutes = in.nextInt();

        // Calendar: месяцы нумеруются с 0, поэтому month - 1
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day, hours, minutes, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // Date получаем из Calendar
        Date date = calendar.getTime();

        System.out.println("Date: " + date);
        System.out.printf("Calendar: %04d/%02d/%02d %02d:%02d%n",
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE));
    }
}