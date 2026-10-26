package ru.mirea.task11;

import java.text.DateFormat;
import java.util.Calendar;

public class zadanie3 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2005, Calendar.MARCH, 15);   // 15 марта 2005

        Student s = new Student("Иван", "Иванов", "ПИ", 2, "ИКБО-01", cal.getTime());

        System.out.println(s);
        System.out.println("Короткий формат:  " + s.getBirthDateString(DateFormat.SHORT));
        System.out.println("Средний формат:   " + s.getBirthDateString(DateFormat.MEDIUM));
        System.out.println("Длинный формат:   " + s.getBirthDateString(DateFormat.LONG));
        System.out.println("Полный формат:    " + s.getBirthDateString(DateFormat.FULL));
        System.out.println("Свой шаблон:      " + s.getBirthDateString("dd.MM.yyyy"));
    }
}