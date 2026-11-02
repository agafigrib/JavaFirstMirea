package ru.mirea.task7;

// Интерфейс для работы со строками
interface StringWorker {
    int countChars(String s);     // а) количество символов
    String oddChars(String s);    // б) символы на нечётных позициях 1, 3, 5...
    String reverse(String s);     // в) перевёрнутая строка
}

// Класс, реализующий интерфейс (теперь он снаружи интерфейса)
class ProcessStrings implements StringWorker {
    public int countChars(String s) {
        return s.length();
    }

    public String oddChars(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i += 2) {   // индексы 0,2,4 = позиции 1,3,5
            result += s.charAt(i);
        }
        return result;
    }

    public String reverse(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }
}

public class zadanie5 {
    public static void main(String[] args) {
        StringWorker worker = new ProcessStrings();
        String text = "Программирование";

        System.out.println("Исходная строка: " + text);
        System.out.println("а) Количество символов: " + worker.countChars(text));
        System.out.println("б) Символы на нечётных позициях: " + worker.oddChars(text));
        System.out.println("в) Перевёрнутая строка: " + worker.reverse(text));
    }
}
