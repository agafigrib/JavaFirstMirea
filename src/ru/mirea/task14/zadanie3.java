package ru.mirea.task14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class zadanie3 {

    public static void main(String[] args) {
        String text = "Ноутбук 25.98 USD, телефон 1500 RUB, наушники 44 ERR, "
                + "часы 0.004 EU, сумка 120.50 EU, кабель 99 RUB";

        // (?<![\d.]) - перед числом не должно быть цифры или точки (чтобы не взять "004" из "0.004")
        // \d+(\.\d{2})? - цифры, затем необязательно точка и ровно 2 цифры (копейки/центы)
        // затем пробел и одна из валют
        Pattern pattern = Pattern.compile("(?<![\\d.])(\\d+(\\.\\d{2})?) (USD|RUB|EU)\\b");
        Matcher matcher = pattern.matcher(text);

        System.out.println("Найденные цены:");
        while (matcher.find()) {
            System.out.println(matcher.group()
                    + "   (сумма: " + matcher.group(1) + ", валюта: " + matcher.group(3) + ")");
        }
    }
}
