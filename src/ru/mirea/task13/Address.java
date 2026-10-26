package ru.mirea.task13;

import java.util.StringTokenizer;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String apartment;

    // заполняет поля из массива частей (недостающие части остаются пустыми)
    private void fill(String[] parts) {
        country = parts.length > 0 ? parts[0].trim() : "";
        region = parts.length > 1 ? parts[1].trim() : "";
        city = parts.length > 2 ? parts[2].trim() : "";
        street = parts.length > 3 ? parts[3].trim() : "";
        house = parts.length > 4 ? parts[4].trim() : "";
        building = parts.length > 5 ? parts[5].trim() : "";
        apartment = parts.length > 6 ? parts[6].trim() : "";
    }

    // а) разделитель только запятая, метод split()
    public static Address fromSplit(String line) {
        Address address = new Address();
        address.fill(line.split(","));
        return address;
    }

    // б) разделитель любой из символов , . ;  (StringTokenizer)
    public static Address fromTokenizer(String line) {
        StringTokenizer tokenizer = new StringTokenizer(line, ",.;");
        String[] parts = new String[tokenizer.countTokens()];
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            parts[i++] = tokenizer.nextToken();
        }
        Address address = new Address();
        address.fill(parts);
        return address;
    }

    @Override
    public String toString() {
        return "Страна: " + country + "\n"
                + "Регион: " + region + "\n"
                + "Город: " + city + "\n"
                + "Улица: " + street + "\n"
                + "Дом: " + house + "\n"
                + "Корпус: " + building + "\n"
                + "Квартира: " + apartment + "\n";
    }
}