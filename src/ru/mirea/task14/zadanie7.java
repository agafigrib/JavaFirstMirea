package ru.mirea.task14;


public class zadanie7 {

    public static boolean isStrong(String password) {
        // (?=.*[A-Z]) - где-то есть заглавная буква
        // (?=.*[a-z]) - где-то есть строчная буква
        // (?=.*\d)    - где-то есть цифра
        // \w{8,}      - 8 и больше символов: буквы, цифры, подчёркивание
        return password.matches("(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)\\w{8,}");
    }

    public static void main(String[] args) {
        String[] tests = {"F032_Password", "TrySpy1", "smart_pass", "A007", "Qwerty123"};
        for (String p : tests) {
            System.out.println(p + " -> " + (isStrong(p) ? "надёжный" : "ненадёжный"));
        }
    }
}
