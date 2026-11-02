package ru.mirea.task14;


public class zadanie2 {

    public static boolean check(String s) {
        // строка должна совпадать с образцом целиком
        return s.matches("abcdefghijklmnopqrstuv18340");
    }

    public static void main(String[] args) {
        String[] tests = {
                "abcdefghijklmnopqrstuv18340",              // правильная
                "abcdefghijklmnoasdfasdpqrstuv18340",       // неправильная
                "abcdefghijklmnopqrstuv18340 "              // лишний пробел в конце
        };
        for (String s : tests) {
            System.out.println("\"" + s + "\" -> " + check(s));
        }
    }
}
