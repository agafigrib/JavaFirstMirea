package ru.mirea.task15;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Задание 1. Калькулятор на основе листинга 15.8:
// два поля для чисел и четыре кнопки: +, -, *, /
class Calculator extends JFrame {
    JTextField jta1 = new JTextField(10);
    JTextField jta2 = new JTextField(10);
    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JButton mult = new JButton("*");
    JButton div = new JButton("/");

    Calculator() {
        super("Calculator");
        setLayout(new FlowLayout());
        setSize(230, 160);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("1st Number"));
        add(jta1);
        add(new JLabel("2nd Number"));
        add(jta2);
        add(plus);
        add(minus);
        add(mult);
        add(div);

        // слушатели через анонимные классы, как в листинге 15.6
        plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                calculate('+');
            }
        });
        minus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                calculate('-');
            }
        });
        mult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                calculate('*');
            }
        });
        div.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                calculate('/');
            }
        });

        setVisible(true);
    }

    // общий метод вычисления, чтобы не повторять код 4 раза
    void calculate(char op) {
        try {
            double x1 = Double.parseDouble(jta1.getText().trim());
            double x2 = Double.parseDouble(jta2.getText().trim());
            double result;
            switch (op) {
                case '+': result = x1 + x2; break;
                case '-': result = x1 - x2; break;
                case '*': result = x1 * x2; break;
                default:
                    if (x2 == 0) {
                        JOptionPane.showMessageDialog(null, "Division by zero!",
                                "alert", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    result = x1 / x2;
            }
            JOptionPane.showMessageDialog(null, "Result = " + result,
                    "Alert", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Numbers !",
                    "alert", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}