package ru.mirea.task6;


interface Convertable {
    double convert(double value);
}


class CelsiusToKelvin implements Convertable {
    public double convert(double c) {
        return c + 273.15;
    }
}


class CelsiusToFahrenheit implements Convertable {
    public double convert(double c) {
        return c * 9 / 5 + 32;
    }
}


public class zadanie11 {
    public static void main(String[] args) {
        double celsius = 25;

        Convertable toKelvin = new CelsiusToKelvin();
        Convertable toFahrenheit = new CelsiusToFahrenheit();

        System.out.println("Температура по Цельсию:  " + celsius + "°C");
        System.out.println("По Кельвину: " + toKelvin.convert(celsius) + " K");
        System.out.println("По Фаренгейту: " + toFahrenheit.convert(celsius) + " °F");
    }
}