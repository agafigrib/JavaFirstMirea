package ru.mirea.task8;

import java.util.Scanner;

public class zadanie9 {
    // сколько последовательностей из a нулей и b единиц, где два нуля не стоят рядом
    public static int count(int a, int b) {
        if (a == 0) {                 // базовый случай 1: нулей не осталось - один способ (все единицы)
            return 1;
        }
        if (b == 0) {                 // базовый случай 2: единиц нет
            return a == 1 ? 1 : 0;    // один ноль поставить можно, два и больше - нельзя
        }
        // шаг рекурсии: смотрим на последний символ
        // 1) последний символ - единица: перед ней любая правильная последовательность из a нулей и b-1 единиц
        // 2) последний символ - ноль: перед ним обязательно единица, а до неё - a-1 нулей и b-1 единиц
        return count(a, b - 1) + count(a - 1, b - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(count(a, b));
    }
}
