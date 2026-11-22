package ru.mirea.task20;

// обобщённый класс с тремя типами T, V, K
public class Triple<T, V, K> {
    private final T first;
    private final V second;
    private final K third;

    public Triple(T first, V second, K third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public K getThird() {
        return third;
    }

    // выводим имена классов трёх полей
    public void printClassNames() {
        System.out.println("T: " + first.getClass().getName());
        System.out.println("V: " + second.getClass().getName());
        System.out.println("K: " + third.getClass().getName());
    }

    public static void main(String[] args) {
        Triple<String, Integer, Double> triple = new Triple<>("Hello", 42, 3.14);
        System.out.println(triple.getFirst() + ", " + triple.getSecond() + ", " + triple.getThird());
        triple.printClassNames();
    }
}