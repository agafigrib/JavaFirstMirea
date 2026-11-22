package ru.mirea.task20;

import java.io.Serializable;

// T - Comparable, V - наследник Animal и Serializable, K - число
public class BoundedTriple<T extends Comparable<T>, V extends Animal & Serializable, K extends Number> {
    private final T first;
    private final V second;
    private final K third;

    public BoundedTriple(T first, V second, K third) {
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

    public void printClassNames() {
        System.out.println("T: " + first.getClass().getName());
        System.out.println("V: " + second.getClass().getName());
        System.out.println("K: " + third.getClass().getName());
    }

    public int compareFirstWith(T other) {
        return first.compareTo(other);
    }

    public double thirdAsDouble() {
        return third.doubleValue();
    }

    public static void main(String[] args) {
        BoundedTriple<String, Dog, Integer> bt1 = new BoundedTriple<>("abc", new Dog("Рекс"), 10);
        bt1.printClassNames();
        System.out.println("\"abc\".compareTo(\"abd\") = " + bt1.compareFirstWith("abd"));
        BoundedTriple<Integer, Cat, Double> bt2 = new BoundedTriple<>(5, new Cat("Мурка"), 2.5);
        bt2.printClassNames();
        System.out.println("K как double: " + bt2.thirdAsDouble());
        // new BoundedTriple<>("a", new Fish("Немо"), 1); - не скомпилируется, Fish не Serializable
    }
}
