package ru.mirea.task8;

import java.util.Scanner;

public class zadanie12 {
    // источник ввода - общий Scanner (как в задании 11)
    static Scanner in = new Scanner(System.in);

    // без параметров, ничего не возвращает: читает число и сразу печатает, если оно нечётное
    public static void printOdd() {
        int x = in.nextInt();
        if (x == 0) {                 // базовый случай: 0 - конец последовательности
            return;
        }
        if (x % 2 != 0) {             // нечётное - печатаем сразу, порядок сохраняется
            System.out.println(x);
        }
        printOdd();                   // шаг рекурсии: обрабатываем остальные числа
    }

    public static void main(String[] args) {
        printOdd();                   // основная программа - только вызов функции
    }
}
