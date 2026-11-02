package ru.mirea.task2.zadanie4;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        ArrayList<String> computers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // по заданию данные вводятся с клавиатуры
        System.out.print("Сколько компьютеров добавить: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("Название компьютера: ");
            Shop.ComputerAdd(computers, sc.nextLine());
        }

        System.out.println("Все компьютеры:");
        Shop.Computers(computers);

        System.out.print("Какой компьютер найти: ");
        Shop.ComputerSearchName(computers, sc.nextLine());

        System.out.print("Какой компьютер удалить: ");
        Shop.ComputerDelete(computers, sc.nextLine());

        System.out.println("После удаления:");
        Shop.Computers(computers);

        Shop.ComputerSearchIndex(computers, 0);
    }
}
