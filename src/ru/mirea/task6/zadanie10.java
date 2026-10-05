package ru.mirea.task6;




    // Интерфейс Printable (задание 6)
    interface Printable {
        void print();
    }

    // Класс Computer (задание 10)
    class Computer implements Printable {
        private String name;
        private int price;
        private String cpu;
        private int ram;

        public Computer(String name, int price, String cpu, int ram) {
            this.name = name;
            this.price = price;
            this.cpu = cpu;
            this.ram = ram;
        }

        @Override
        public void print() {
            System.out.println("Компьютер: " + name);
            System.out.println("Процессор: " + cpu);
            System.out.println("ОЗУ: " + ram + " ГБ");
            System.out.println("Цена: " + price + " руб.");
            System.out.println("-----------------------------");
        }
    }

    // Главный класс
    public class zadanie10 {
        public static void main(String[] args) {
            // Массив типа Printable, содержащий компьютеры
            Printable[] computers = new Printable[3];

            computers[0] = new Computer("Acer Aspire", 45000, "Intel Core i3", 8);
            computers[1] = new Computer("Lenovo IdeaPad", 62000, "Intel Core i5", 16);
            computers[2] = new Computer("Apple MacBook Air", 99000, "Apple M2", 8);

            // Проходим по массиву и вызываем print() для каждого объекта
            for (Printable item : computers) {
                item.print();
            }
        }
    }

