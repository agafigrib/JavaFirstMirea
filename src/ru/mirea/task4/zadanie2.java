package ru.mirea.task4;


    enum Size {
        XXS(32),
        XS(34),
        S(36),
        M(38),
        L(40);

        int euroSize;

        Size(int euroSize) {
            this.euroSize = euroSize;
        }

        String getDescription() {
            if (this == XXS) {
                return "Детский размер";
            } else {
                return "Взрослый размер";
            }
        }
    }

    abstract class Clothes {
        Size size;
        double price;
        String color;

        Clothes(Size size, double price, String color) {
            this.size = size;
            this.price = price;
            this.color = color;
        }

        void print() {
            System.out.println(
                    "Размер: " + size +
                            ", цена: " + price +
                            ", цвет: " + color
            );
        }
    }

    class TShirt extends Clothes {
        TShirt(Size size, double price, String color) {
            super(size, price, color);
        }
    }

    class Pants extends Clothes {
        Pants(Size size, double price, String color) {
            super(size, price, color);
        }
    }

    class Skirt extends Clothes {
        Skirt(Size size, double price, String color) {
            super(size, price, color);
        }
    }

    class Tie extends Clothes {
        Tie(Size size, double price, String color) {
            super(size, price, color);
        }
    }

    public class zadanie2 {
        public static void main(String[] args) {

            TShirt shirt = new TShirt(Size.M, 1500, "Белый");
            Pants pants = new Pants(Size.L, 2500, "Чёрный");
            Skirt skirt = new Skirt(Size.S, 2000, "Красный");
            Tie tie = new Tie(Size.M, 1000, "Синий");

            System.out.println("Футболка:");
            shirt.print();

            System.out.println("\nШтаны:");
            pants.print();

            System.out.println("\nЮбка:");
            skirt.print();

            System.out.println("\nГалстук:");
            tie.print();

            System.out.println("\nРазмер M:");
            System.out.println("Европейский размер: " + Size.M.euroSize);
            System.out.println(Size.M.getDescription());
        }
    }

