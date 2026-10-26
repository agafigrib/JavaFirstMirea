package ru.mirea.task11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class zadanie5 {
    static final int N = 100_000;       // размер списков
    static final int OPS = 10_000;      // число операций для медленных случаев

    // измеряет время выполнения кода в миллисекундах
    static double measure(Runnable code) {
        long start = System.nanoTime();
        code.run();
        return (System.nanoTime() - start) / 1_000_000.0;
    }

    static List<Integer> filled(List<Integer> list) {
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        return list;
    }

    static void test(String name, List<Integer> list) {
        System.out.println("=== " + name + " ===");

        // добавление в конец
        List<Integer> a = new ArrayList<>();
        if (list instanceof LinkedList) {
            a = new LinkedList<>();
        }
        final List<Integer> addList = a;
        System.out.printf("Добавление в конец (%d шт.): %.2f мс%n", N,
                measure(() -> { for (int i = 0; i < N; i++) addList.add(i); }));

        // вставка в начало
        List<Integer> b = filled(list instanceof LinkedList ? new LinkedList<>() : new ArrayList<>());
        System.out.printf("Вставка в начало (%d шт.): %.2f мс%n", OPS,
                measure(() -> { for (int i = 0; i < OPS; i++) b.add(0, i); }));

        // вставка в середину
        List<Integer> c = filled(list instanceof LinkedList ? new LinkedList<>() : new ArrayList<>());
        System.out.printf("Вставка в середину (%d шт.): %.2f мс%n", OPS,
                measure(() -> { for (int i = 0; i < OPS; i++) c.add(c.size() / 2, i); }));

        // удаление из начала
        List<Integer> d = filled(list instanceof LinkedList ? new LinkedList<>() : new ArrayList<>());
        System.out.printf("Удаление из начала (%d шт.): %.2f мс%n", OPS,
                measure(() -> { for (int i = 0; i < OPS; i++) d.remove(0); }));

        // удаление из конца
        List<Integer> e = filled(list instanceof LinkedList ? new LinkedList<>() : new ArrayList<>());
        System.out.printf("Удаление из конца (%d шт.): %.2f мс%n", OPS,
                measure(() -> { for (int i = 0; i < OPS; i++) e.remove(e.size() - 1); }));

        // поиск по образцу (значению): ищем элемент ближе к концу
        List<Integer> f = filled(list instanceof LinkedList ? new LinkedList<>() : new ArrayList<>());
        System.out.printf("Поиск по значению (%d поисков): %.2f мс%n", 1000,
                measure(() -> { for (int i = 0; i < 1000; i++) f.indexOf(N - 1 - i); }));

        System.out.println();
    }

    public static void main(String[] args) {
        test("ArrayList", new ArrayList<>());
        test("LinkedList", new LinkedList<>());
    }
}