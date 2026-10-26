package ru.mirea.task13;

public class PhoneFormatter {

    public static String format(String phone) {
        String p = phone.trim();

        // российский формат 8XXXXXXXXXX заменяем на +7XXXXXXXXXX
        if (p.startsWith("8") && p.length() == 11) {
            p = "+7" + p.substring(1);
        }

        // после плюса: код страны (1-3 цифры) и ровно 10 цифр номера
        if (!p.matches("\\+\\d{11,13}")) {
            return "Неверный формат номера: " + phone;
        }

        String digits = p.substring(1);
        int codeLength = digits.length() - 10;
        String code = digits.substring(0, codeLength);
        String number = digits.substring(codeLength);

        return "+" + code
                + number.substring(0, 3) + "-"
                + number.substring(3, 6) + "-"
                + number.substring(6);
    }

    public static void main(String[] args) {
        System.out.println(format("+79175655655"));
        System.out.println(format("+104289652211"));
        System.out.println(format("89175655655"));
        System.out.println(format("12345"));
    }
}
