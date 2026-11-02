package ru.mirea.task12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

// Анимация из картинки, состоящей из нескольких кадров (спрайт-лист).
// Кадры расположены в картинке по горизонтали один за другим.
// Запуск: java Animation sprite.png 8   (8 - количество кадров)
class Animation extends JFrame {
    BufferedImage[] frames;  // массив кадров
    int current = 0;         // номер текущего кадра

    public Animation(String path, int frameCount) throws Exception {
        super("Анимация");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 1. Загружаем всю картинку целиком
        BufferedImage sheet = ImageIO.read(new File(path));

        // 2. Режем её на кадры одинаковой ширины
        int w = sheet.getWidth() / frameCount;
        int h = sheet.getHeight();
        frames = new BufferedImage[frameCount];
        for (int i = 0; i < frameCount; i++) {
            frames[i] = sheet.getSubimage(i * w, 0, w, h);
        }

        // 3. Панель, которая рисует текущий кадр (анонимный класс)
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(frames[current], 0, 0, this);
            }
        };
        panel.setPreferredSize(new Dimension(w, h));
        add(panel);

        // 4. Таймер каждые 100 мс переключает кадр и перерисовывает панель
        Timer timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                current = (current + 1) % frames.length; // по кругу: 0,1,..,n-1,0,...
                panel.repaint();
            }
        });
        timer.start();

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws Exception {
        String path = args.length > 0 ? args[0] : "sprite.png";
        int count = args.length > 1 ? Integer.parseInt(args[1]) : 8;
        new Animation(path, count).setVisible(true);
    }
}