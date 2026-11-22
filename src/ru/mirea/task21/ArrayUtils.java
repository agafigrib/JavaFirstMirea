package ru.mirea.task21;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {
    private ArrayUtils() {
    }

    // массив в список
    public static <E> List<E> arrayToList(E[] array) {
        List<E> list = new ArrayList<>();
        for (E e : array) {
            list.add(e);
        }
        return list;
    }

    // элемент по индексу
    public static <E> E getElement(E[] array, int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + array.length);
        }
        return array[index];
    }

    public static void main(String[] args) {
        String[] strArray = {"one", "two", "three"};
        Integer[] intArray = {55, 66, 77};
        List<String> strList = arrayToList(strArray);
        List<Integer> intList = arrayToList(intArray);
        System.out.println(strList);
        System.out.println(intList);
        System.out.println("getElement(strArray, 2) = " + getElement(strArray, 2));
        // стирание типов: класс у обоих списков один и тот же
        System.out.println("ArrayList<String> и ArrayList<Integer> - один класс: "
                + (new ArrayList<String>().getClass() == new ArrayList<Integer>().getClass()));
    }
}