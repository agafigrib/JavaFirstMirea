package ru.mirea.task4;

enum Size {
    XXS(32) {
        // для константы XXS метод переопределён
        @Override
        String getDescription() {
            return "Детский размер";
        }
    },
    XS(34),
    S(36),
    M(38),
    L(40);

    int euroSize;

    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    String getDescription() {
        return "Взрослый размер";
    }
}

interface MenClothing {
    void dressMan();
}

interface WomenClothing {
    void dressWomen();
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

class TShirt extends Clothes implements MenClothing, WomenClothing {
    TShirt(Size size, double price, String color) {
        super(size, price, color);
    }

    public void dressMan() {
        System.out.print("Футболка (мужская): ");
        print();
    }

    public void dressWomen() {
        System.out.print("Футболка (женская): ");
        print();
    }
}

class Pants extends Clothes implements MenClothing, WomenClothing {
    Pants(Size size, double price, String color) {
        super(size, price, color);
    }

    public void dressMan() {
        System.out.print("Штаны (мужские): ");
        print();
    }

    public void dressWomen() {
        System.out.print("Штаны (женские): ");
        print();
    }
}

class Skirt extends Clothes implements WomenClothing {
    Skirt(Size size, double price, String color) {
        super(size, price, color);
    }

    public void dressWomen() {
        System.out.print("Юбка: ");
        print();
    }
}

class Tie extends Clothes implements MenClothing {
    Tie(Size size, double price, String color) {
        super(size, price, color);
    }

    public void dressMan() {
        System.out.print("Галстук: ");
        print();
    }
}

class Atelier {
    // массив типа Clothes - общий родитель, поэтому в нём может лежать любая одежда
    void dressWomen(Clothes[] clothes) {
        for (Clothes c : clothes) {
            if (c instanceof WomenClothing) {
                ((WomenClothing) c).dressWomen();
            }
        }
    }

    void dressMan(Clothes[] clothes) {
        for (Clothes c : clothes) {
            if (c instanceof MenClothing) {
                ((MenClothing) c).dressMan();
            }
        }
    }
}

public class zadanie2 {
    public static void main(String[] args) {

        Clothes[] clothes = {
                new TShirt(Size.M, 1500, "Белый"),
                new Pants(Size.L, 2500, "Чёрный"),
                new Skirt(Size.S, 2000, "Красный"),
                new Tie(Size.M, 1000, "Синий")
        };

        Atelier atelier = new Atelier();

        System.out.println("Женская одежда:");
        atelier.dressWomen(clothes);

        System.out.println("\nМужская одежда:");
        atelier.dressMan(clothes);

        System.out.println("\nРазмеры:");
        for (Size size : Size.values()) {
            System.out.println(size + " - европейский " + size.euroSize + ", " + size.getDescription());
        }
    }
}
