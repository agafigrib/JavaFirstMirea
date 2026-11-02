package ru.mirea.task15;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Задание 4. Калькулятор с кнопками, как на рисунке 15.10
class SimpleCalculator extends JFrame {
    JTextField display = new JTextField();   // экран калькулятора
    double first = 0;        // первое число
    String operation = "";   // выбранная операция (+, -, *, /)
    boolean newNumber = true; // true - следующая цифра начинает новое число

    // подписи кнопок в том порядке, в каком они стоят на рисунке
    String[] labels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
    };

    SimpleCalculator() {
        super("Calculator");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        add(display, BorderLayout.NORTH);

        // панель кнопок - таблица 4 x 4 (GridLayout)
        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));

        // один общий слушатель для всех кнопок (анонимный класс)
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = e.getActionCommand(); // надпись на нажатой кнопке
                buttonPressed(text);
            }
        };

        for (String label : labels) {
            JButton b = new JButton(label);
            b.addActionListener(listener);
            panel.add(b);
        }
        add(panel, BorderLayout.CENTER);

        JLabel title = new JLabel("Simple Calculator", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.PLAIN, 10));
        add(title, BorderLayout.SOUTH);

        setVisible(true);
    }

    void buttonPressed(String text) {
        if (text.matches("[0-9]")) {               // нажата цифра
            if (newNumber) {
                display.setText(text);
                newNumber = false;
            } else {
                display.setText(display.getText() + text);
            }
        } else if (text.equals(".")) {             // десятичная точка
            if (newNumber) {
                display.setText("0.");
                newNumber = false;
            } else if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }
        } else if (text.equals("=")) {             // равно
            calculate();
            operation = "";
        } else {                                   // +, -, *, /
            if (!operation.isEmpty() && !newNumber) {
                calculate();                       // 2 + 3 + ... - считаем промежуточно
            }
            first = getNumber();
            operation = text;
            newNumber = true;
        }
    }

    double getNumber() {
        String t = display.getText();
        return t.isEmpty() ? 0 : Double.parseDouble(t);
    }

    void calculate() {
        if (operation.isEmpty()) return;
        double second = getNumber();
        double result;
        switch (operation) {
            case "+": result = first + second; break;
            case "-": result = first - second; break;
            case "*": result = first * second; break;
            default:
                if (second == 0) {
                    display.setText("Error");
                    newNumber = true;
                    operation = "";
                    return;
                }
                result = first / second;
        }
        // если результат целый, показываем без ".0"
        if (result == (long) result) {
            display.setText(String.valueOf((long) result));
        } else {
            display.setText(String.valueOf(result));
        }
        first = result;
        newNumber = true;
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}