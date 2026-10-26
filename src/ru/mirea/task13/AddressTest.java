package ru.mirea.task13;

public class AddressTest {
    public static void main(String[] args) {
        String[] commaLines = {
                "Россия, Московская область, Москва, Ленина, 5, 2, 17",
                "Россия,Татарстан , Казань,  Баумана,10,1,45",
                "Беларусь, Минская область, Минск, Мира, 3, 1, 8",
                "Россия, Тверская область, Тверь, Победы, 12, 3, 101"
        };
        System.out.println("=== split() ===");
        for (String line : commaLines) {
            System.out.println(Address.fromSplit(line));
        }

        String[] mixedLines = {
                "Россия; Московская область; Москва; Ленина; 5; 2; 17",
                "Россия, Татарстан; Казань. Баумана, 10; 1; 45",
                "Беларусь. Минская область. Минск. Мира. 3. 1. 8",
                "Россия; Тверская область, Тверь; Победы; 12; 3, 101"
        };
        System.out.println("=== StringTokenizer ===");
        for (String line : mixedLines) {
            System.out.println(Address.fromTokenizer(line));
        }
    }
}