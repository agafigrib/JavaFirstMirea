package ru.mirea.task7;


interface StringWorker {
    int countChars(String s);

    String oddChars(String s);

    String reverse(String s);

    // Класс, реализующий интерфейс
    class ProcessStrings implements StringWorker {

        //  считаем символы
        public int countChars(String s) {
            return s.length();
        }


        public String oddChars(String s) {
            String result = "";
            for (int i = 0; i < s.length(); i += 2) {
                result += s.charAt(i);
            }
            return result;
        }

        //  переворачиваем строку
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

            System.out.println("Исходная строка:  " + text);
            System.out.println("а) Количество символов: " + worker.countChars(text));
            System.out.println("б) Символы на нечётных позициях: " + worker.oddChars(text));
            System.out.println("в) Перевёрнутая строка: " + worker.reverse(text));
        }
    }
}