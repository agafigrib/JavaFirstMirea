package ru.mirea.task9;

public class InsertionSortTest {

    // сортировка вставками для ЛЮБЫХ Comparable-объектов (полиморфизм)
    public static void insertionSort(Comparable[] list) {
        for (int i = 1; i < list.length; i++) {
            Comparable key = list[i];        // элемент, который вставляем
            int j = i - 1;
            // сдвигаем вправо всё, что больше key
            while (j >= 0 && list[j].compareTo(key) > 0) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;               // вставляем на освободившееся место
        }
    }

    public static void printArray(Object[] array) {
        for (Object o : array) {
            System.out.println(o);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student(1045, "Иван", "Иванов", 4.2),
                new Student(1012, "Анна", "Сидорова", 4.9),
                new Student(1078, "Пётр", "Петров", 3.8),
                new Student(1003, "Мария", "Орлова", 4.5),
                new Student(1061, "Олег", "Козлов", 3.5)
        };

        System.out.println("До сортировки:");
        printArray(students);

        insertionSort(students);

        System.out.println("После сортировки вставками по iDNumber:");
        printArray(students);

        // тот же метод сортирует и строки - String тоже реализует Comparable
        String[] names = {"Олег", "Анна", "Пётр", "Иван"};
        insertionSort(names);
        System.out.println("Тот же метод для строк:");
        printArray(names);
    }
}
