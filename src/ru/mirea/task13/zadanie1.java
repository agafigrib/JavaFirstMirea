package ru.mirea.task13;

public class zadanie1 {
    public static void work(String s) {
        // 2. последний символ
        System.out.println("Последний символ: " + s.charAt(s.length() - 1));

        // 3. заканчивается ли на "!!!"
        System.out.println("Заканчивается на !!!: " + s.endsWith("!!!"));

        // 4. начинается ли с "I like"
        System.out.println("Начинается с I like: " + s.startsWith("I like"));

        // 5. содержит ли "Java"
        System.out.println("Содержит Java: " + s.contains("Java"));

        // 6. позиция подстроки "Java"
        int index = s.indexOf("Java");
        System.out.println("Позиция Java: " + index);

        // 7. заменить все "a" на "o"
        System.out.println("Замена a на o: " + s.replace('a', 'o'));

        // 8. верхний регистр
        System.out.println("Верхний регистр: " + s.toUpperCase());

        // 9. нижний регистр
        System.out.println("Нижний регистр: " + s.toLowerCase());

        // 10. вырезать "Java" через substring
        String cut = s.substring(0, index) + s.substring(index + "Java".length());
        System.out.println("Без Java: " + cut);
    }

    public static void main(String[] args) {
        work("I like Java!!!");
    }
}

