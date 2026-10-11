package ru.mirea.task7;

// Интерфейс
interface MathCalculable {
    double PI = 3.14159265358979;

    double power(double x, int n);   // возведение в степень
    double absComplex(double re, double im); // модуль комплексного числа
}

// Реализация интерфейса
class MathFunc implements MathCalculable {

    public double power(double x, int n) {
        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    public double absComplex(double re, double im) {
        return Math.sqrt(re * re + im * im);
    }

    // Длина окружности: 2 * PI * r
    public double circleLength(double r) {
        return 2 * PI * r;
    }
}

// Проверка
public class zadanie4 {
    public static void main(String[] args) {

        MathCalculable mc = new MathFunc();

        System.out.println("2^10 = " + mc.power(2, 10));
        System.out.println("|3 + 4i| = " + mc.absComplex(3, 4));


        MathFunc mf = new MathFunc();
        System.out.println("Длина окружности r=5: " + mf.circleLength(5));
    }
}