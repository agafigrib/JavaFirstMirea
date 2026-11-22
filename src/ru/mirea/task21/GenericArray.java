package ru.mirea.task21;

import java.util.Arrays;

// хранит массив любого типа (int, long - через Integer, Long)
public class GenericArray<E> {
    private final E[] array;

    public GenericArray(E[] array) {
        this.array = array;
    }

    // элемент по индексу
    public E get(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + array.length);
        }
        return array[index];
    }

    public void set(int index, E value) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + array.length);
        }
        array[index] = value;
    }

    public int size() {
        return array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        GenericArray<Integer> ints = new GenericArray<>(new Integer[]{10, 20, 30});
        GenericArray<Long> longs = new GenericArray<>(new Long[]{100L, 200L});
        GenericArray<String> strings = new GenericArray<>(new String[]{"a", "b", "c", "d"});
        System.out.println("ints = " + ints + ", ints.get(1) = " + ints.get(1));
        System.out.println("longs = " + longs + ", longs.get(0) = " + longs.get(0));
        System.out.println("strings = " + strings + ", strings.get(3) = " + strings.get(3));
        try {
            ints.get(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ints.get(5): " + e.getMessage());
        }
    }
}