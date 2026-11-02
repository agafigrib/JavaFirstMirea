package ru.mirea.task15;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Задание 2. Выбор страны из выпадающего списка JComboBox.
// При выборе страны выводится информация о ней.
class CountryChooser extends JFrame {
    String[] countries = {"Australia", "China", "England", "Russia"};

    // информация о странах, индекс совпадает с индексом в массиве countries
    String[] info = {
            "Australia\nСтолица: Канберра\nНаселение: ~27 млн\nЯзык: английский",
            "China\nСтолица: Пекин\nНаселение: ~1,4 млрд\nЯзык: китайский",
            "England\nСтолица: Лондон\nНаселение: ~57 млн\nЯзык: английский",
            "Russia\nСтолица: Москва\nНаселение: ~146 млн\nЯзык: русский"
    };

    JComboBox<String> combo = new JComboBox<>(countries);
    JTextArea area = new JTextArea(5, 20);

    CountryChooser() {
        super("Hello Swing");
        setLayout(new FlowLayout());
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        area.setEditable(false);      // в поле можно только читать
        area.setText(info[0]);        // сразу показываем первую страну

        add(combo);
        add(area);

        // у JComboBox тоже есть ActionListener - срабатывает при выборе пункта
        combo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = combo.getSelectedIndex(); // номер выбранного пункта
                area.setText(info[index]);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new CountryChooser();
    }
}