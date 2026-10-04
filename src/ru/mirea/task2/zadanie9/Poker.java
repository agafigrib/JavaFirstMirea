package ru.mirea.task2.zadanie9;

import java.util.Random;
import java.util.Scanner;

public class Poker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Количество игроков: ");
        int n = scanner.nextInt();

        String[] suits = {
                "Черви",
                "Буби",
                "Крести",
                "Пики"
        };

        String[] ranks = {
                "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "Валет", "Дама",
                "Король", "Туз"
        };

        String[] cards = new String[52];

        int k = 0;

        for (int i = 0; i < suits.length; i++) {

            for (int j = 0; j < ranks.length; j++) {

                cards[k] = ranks[j] + " " + suits[i];

                k++;
            }
        }

        Random random = new Random();

        // Перемешиваем карты
        for (int i = 0; i < 52; i++) {

            int j = random.nextInt(52);

            String temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }

        // Раздаём карты
        k = 0;

        for (int player = 1; player <= n; player++) {

            System.out.println("Игрок " + player);

            for (int card = 0; card < 5; card++) {

                System.out.println(cards[k]);

                k++;
            }

            System.out.println();
        }
    }
}