package ru.mirea.task12;

import javax.swing.*;
import java.awt.*;

// Абстрактный класс фигуры: общие свойства - цвет и позиция
abstract class Shape {
    protected Color color; // цвет фигуры
    protected int x, y;    // позиция фигуры (левый верхний угол)

    public Shape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    // каждая фигура сама знает, как себя нарисовать
    public abstract void draw(Graphics g);
}

// Круг
class Circle extends Shape {
    private int radius;

    public Circle(Color color, int x, int y, int radius) {
        super(color, x, y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, radius * 2, radius * 2);
    }
}

// Прямоугольник
class Rectangle extends Shape {
    private int width, height;

    public Rectangle(Color color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}

// Треугольник
class Triangle extends Shape {
    private int size;

    public Triangle(Color color, int x, int y, int size) {
        super(color, x, y);
        this.size = size;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int[] xs = {x, x + size, x + size / 2};
        int[] ys = {y + size, y + size, y};
        g.fillPolygon(xs, ys, 3);
    }
}

// Окно программы - наследуемся от JFrame, как в листинге 12.1
class RandomShapes extends JFrame {
    Shape[] shapes = new Shape[20]; // массив из 20 фигур

    public RandomShapes() {
        super("20 случайных фигур");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // создаём 20 случайных фигур
        for (int i = 0; i < shapes.length; i++) {
            int r = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);
            Color color = new Color(r, g, b);          // случайный цвет
            int x = (int) (Math.random() * 650);       // случайная позиция
            int y = (int) (Math.random() * 450);
            int type = (int) (Math.random() * 3);      // 0, 1 или 2 - тип фигуры

            if (type == 0) {
                shapes[i] = new Circle(color, x, y, 20 + (int) (Math.random() * 40));
            } else if (type == 1) {
                shapes[i] = new Rectangle(color, x, y,
                        30 + (int) (Math.random() * 100), 30 + (int) (Math.random() * 80));
            } else {
                shapes[i] = new Triangle(color, x, y, 40 + (int) (Math.random() * 80));
            }
        }

        // панель, на которой рисуем; метод paintComponent переопределён в анонимном классе
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Shape s : shapes) {
                    s.draw(g); // полиморфизм: вызывается draw() нужного класса
                }
            }
        };
        panel.setBackground(Color.WHITE);
        add(panel);
    }

    public static void main(String[] args) {
        new RandomShapes().setVisible(true);
    }
}
