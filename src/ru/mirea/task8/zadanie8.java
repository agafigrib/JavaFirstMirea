package ru.mirea.task8;

import java.util.Scanner;

public class zadanie8 {
    public static boolean isPalindrome(String s, int left, int right) {
        if (left >= right) {                       // базовый случай
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return isPalindrome(s, left + 1, right - 1);   // шаг рекурсии
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.next();
        if (isPalindrome(word, 0, word.length() - 1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}