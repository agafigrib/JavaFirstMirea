package ru.mirea.task2.zadanie5;

public class PitomnikSobak {

    public static void main(String[] args) {

        Dog[] dogs = new Dog[3];

        dogs[0] = new Dog("Шарик", 3);
        dogs[1] = new Dog("Бобик", 5);
        dogs[2] = new Dog("Рекс", 2);

        for (int i = 0; i < 3; i++) {
            System.out.println(dogs[i]);

        }
    }
}

