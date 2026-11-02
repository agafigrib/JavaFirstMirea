package ru.mirea.task12;

import javax.swing.*;
import java.awt.*;

// Окно, которое показывает картинку. Путь к картинке передаётся
// в аргументах командной строки: java ImageWindow picture.png
class ImageWindow extends JFrame {

    public ImageWindow(String path) {
        super("Картинка: " + path);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ImageIcon загружает картинку из файла по указанному пути
        ImageIcon icon = new ImageIcon(path);

        // если файл не найден или это не картинка - ширина будет -1
        if (icon.getIconWidth() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Не удалось загрузить картинку: " + path,
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        // JLabel умеет показывать не только текст, но и картинку
        JLabel label = new JLabel(icon);
        add(label, BorderLayout.CENTER);

        pack();                       // размер окна подгоняется под картинку
        setLocationRelativeTo(null);  // окно по центру экрана
    }

    public static void main(String[] args) {
        // проверяем, что путь передали
        if (args.length == 0) {
            System.out.println("Укажите путь к картинке: java ImageWindow <путь>");
            return;
        }
        new ImageWindow(args[0]).setVisible(true);
    }
}