package ru.mirea.task4;

enum Season {
    WINTER(-10),
    SPRING(10),
    SUMMER(25),
    AUTUMN(10);

    int temperature;

    Season(int temperature) {
        this.temperature = temperature;
    }

    String getDescription() {
        if (this == SUMMER) {
            return "Теплое время года";
        } else {
            return "Холодное время года";
        }
    }
}

public class zadanie1 {
    public static void main(String[] args) {

        Season favorite = Season.SUMMER;

        System.out.println("Мое любимое время года: " + favorite);
        System.out.println("Средняя температура: " + favorite.temperature);
        System.out.println("Описание: " + favorite.getDescription());

        System.out.println();

        switch (favorite) {
            case WINTER:
                System.out.println("Я люблю зиму");
                break;
            case SPRING:
                System.out.println("Я люблю весну");
                break;
            case SUMMER:
                System.out.println("Я люблю лето");
                break;
            case AUTUMN:
                System.out.println("Я люблю осень");
                break;
        }

        System.out.println();

        for (Season season : Season.values()) {
            System.out.println(
                    season + " : " +
                            season.temperature + " градусов, " +
                            season.getDescription()
            );
        }
    }
}