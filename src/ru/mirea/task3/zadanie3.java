package ru.mirea.task3;




    public class zadanie3 {
        public static void main(String[] args) {

            // Создаём Double
            Double a = Double.valueOf(10.5);

            // String в double
            String text = "20.5";
            double b = Double.parseDouble(text);

            // Double в разные типы
            byte x1 = a.byteValue();
            short x2 = a.shortValue();
            int x3 = a.intValue();
            long x4 = a.longValue();
            float x5 = a.floatValue();
            double x6 = a.doubleValue();

            // Вывод
            System.out.println("Double: " + a);
            System.out.println("String в double: " + b);

            System.out.println("byte: " + x1);
            System.out.println("short: " + x2);
            System.out.println("int: " + x3);
            System.out.println("long: " + x4);
            System.out.println("float: " + x5);
            System.out.println("double: " + x6);

            // double в String
            String result = Double.toString(3.14);

            System.out.println("double в String: " + result);
        }
    }

