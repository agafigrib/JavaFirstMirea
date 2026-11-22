package ru.mirea.task20;

public class MinMax<T extends Comparable<T>> {
    private final T[] array;

    public MinMax(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }
        this.array = array;
    }

    // поиск минимума
    public T min() {
        T result = array[0];
        for (T item : array) {
            if (item.compareTo(result) < 0) {
                result = item;
            }
        }
        return result;
    }

    // поиск максимума
    public T max() {
        T result = array[0];
        for (T item : array) {
            if (item.compareTo(result) > 0) {
                result = item;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] ints = {5, 3, 9, -2, 7};
        MinMax<Integer> mmInt = new MinMax<>(ints);
        System.out.println("Integer: min = " + mmInt.min() + ", max = " + mmInt.max());
        String[] strs = {"pear", "apple", "orange", "banana"};
        MinMax<String> mmStr = new MinMax<>(strs);
        System.out.println("String: min = " + mmStr.min() + ", max = " + mmStr.max());
        Double[] dbls = {2.5, -1.5, 8.25};
        MinMax<Double> mmDbl = new MinMax<>(dbls);
        System.out.println("Double: min = " + mmDbl.min() + ", max = " + mmDbl.max());
    }
}