package ru.mirea.task19;

import java.util.Scanner;

public class OrderDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // спрашиваем данные, пока не введут правильный ИНН
        while (true) {
            System.out.print("Введите ФИО: ");
            String fio = sc.hasNextLine() ? sc.nextLine() : "";
            System.out.print("Введите ИНН: ");
            String inn = sc.hasNextLine() ? sc.nextLine().trim() : "";
            try {
                OnlineOrder order = new OnlineOrder(fio, inn);
                System.out.println(order);
                break;
            } catch (InvalidInnException e) {
                System.out.println("Ошибка ИНН: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
            if (!sc.hasNextLine()) {
                break;
            }
        }
    }
}