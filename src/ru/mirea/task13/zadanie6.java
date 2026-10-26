package ru.mirea.task13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class zadanie6 {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите имя файла: ");
        String fileName = console.readLine();

        // читаем слова из файла
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.split(" ")) {
                    if (!word.isEmpty()) {
                        list.add(word);
                    }
                }
            }
        }

        String[] words = list.toArray(new String[0]);
        StringBuilder result = getLine(words);
        if (result.length() == 0) {
            System.out.println("Цепочку из всех слов составить нельзя");
        } else {
            System.out.println(result);
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        if (words == null || words.length == 0) {
            return result;
        }

        boolean[] used = new boolean[words.length];
        String[] chain = new String[words.length];

        // пробуем каждое слово как начало цепочки
        for (int i = 0; i < words.length; i++) {
            used[i] = true;
            chain[0] = words[i];
            if (build(words, used, chain, 1)) {
                for (int k = 0; k < chain.length; k++) {
                    if (k > 0) {
                        result.append(' ');
                    }
                    result.append(chain[k]);
                }
                return result;
            }
            used[i] = false;
        }
        return result;   // цепочки нет, результат пустой
    }

    // рекурсивный подбор следующего слова (count - сколько слов уже в цепочке)
    private static boolean build(String[] words, boolean[] used, String[] chain, int count) {
        if (count == words.length) {              // базовый случай: все слова использованы
            return true;
        }
        String prev = chain[count - 1];
        char last = Character.toLowerCase(prev.charAt(prev.length() - 1));

        for (int j = 0; j < words.length; j++) {
            if (!used[j] && Character.toLowerCase(words[j].charAt(0)) == last) {
                used[j] = true;
                chain[count] = words[j];
                if (build(words, used, chain, count + 1)) {   // шаг рекурсии
                    return true;
                }
                used[j] = false;                  // откат, пробуем другое слово
            }
        }
        return false;
    }
}