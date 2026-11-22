package ru.mirea.task21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    @SafeVarargs
    // создаёт ArrayList из переданных элементов
    public static <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> list = new ArrayList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }

    @SafeVarargs
    // создаёт HashSet из переданных элементов
    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> set = new HashSet<>();
        for (T element : elements) {
            set.add(element);
        }
        return set;
    }

    // создаёт HashMap из списка ключей и списка значений
    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException("Количество ключей (" + keys.size()
                    + ") не равно количеству значений (" + values.size() + ")");
        }
        HashMap<K, V> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }
        return map;
    }

    public static void main(String[] args) {
        ArrayList<String> list = newArrayList("a", "b", "a");
        Set<Integer> set = newHashSet(1, 2, 2, 3);
        Map<String, Integer> map = newHashMap(newArrayList("one", "two", "three"), newArrayList(1, 2, 3));
        System.out.println("ArrayList: " + list);
        System.out.println("HashSet:   " + set);
        System.out.println("HashMap:   " + map);
        try {
            newHashMap(newArrayList("k1", "k2"), newArrayList(1));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}