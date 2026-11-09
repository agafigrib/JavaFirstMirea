package ru.mirea.task9;


import java.util.ArrayList;
import java.util.List;


public class zadanie3 {

    // сортировка слиянием для списка
    public static List<Student> mergeSort(List<Student> list) {
        if (list.size() <= 1) {                  // базовый случай: 0 или 1 элемент уже отсортирован
            return list;
        }
        int middle = list.size() / 2;
        // делим список на две половины
        List<Student> left = mergeSort(new ArrayList<>(list.subList(0, middle)));
        List<Student> right = mergeSort(new ArrayList<>(list.subList(middle, list.size())));
        return merge(left, right);               // сливаем отсортированные половины
    }

    // слияние двух ОТСОРТИРОВАННЫХ списков в один отсортированный
    public static List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }
        // дописываем остаток того списка, который не закончился
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }
        return result;
    }

    public static void printList(List<Student> list) {
        for (Student s : list) {
            System.out.println(s);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // первый список (например, группа 1)
        List<Student> group1 = new ArrayList<>();
        group1.add(new Student(1045, "Иван", "Иванов", 4.2));
        group1.add(new Student(1012, "Анна", "Сидорова", 4.9));
        group1.add(new Student(1078, "Пётр", "Петров", 3.8));

        // второй список (например, группа 2)
        List<Student> group2 = new ArrayList<>();
        group2.add(new Student(1003, "Мария", "Орлова", 4.5));
        group2.add(new Student(1061, "Олег", "Козлов", 3.5));
        group2.add(new Student(1030, "Елена", "Смирнова", 4.7));

        System.out.println("Первый список:");
        printList(group1);
        System.out.println("Второй список:");
        printList(group2);

        // 1) сортируем каждый список слиянием
        List<Student> sorted1 = mergeSort(group1);
        List<Student> sorted2 = mergeSort(group2);

        // 2) сливаем два отсортированных списка в один
        List<Student> all = merge(sorted1, sorted2);

        System.out.println("Общий отсортированный список (по iDNumber):");
        printList(all);
    }
}