package ru.mirea.task17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public interface StudentList {

    void add(Student student);
    boolean remove(int number);
    Student get(int number);
    void printAll();
    void clear();
    boolean isEmpty();
    int size();

    //  один элемент (узел) списка на экран
    default void printElement(int number) {
        Student s = get(number);
        if (s == null) {
            System.out.println("Нет элемента с номером " + number);
        } else {
            System.out.print(number + ". ");
            s.print();
        }
    }

    //  список в файл (каждый студент - отдельная строка)
    default void saveToFile(String fileName) throws IOException {
        // try-with-resources: файл закроется сам, даже если при записи произойдёт ошибка
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 1; i <= size(); i++) {
                writer.write(get(i).toFileLine() + "\n");
            }
        }
    }

    //  список из файла (старое содержимое удаляется, но только если файл прочитан без ошибок)
    default void loadFromFile(String fileName) throws IOException {
        // сначала читаем весь файл во временный буфер - текущий список пока не трогаем
        ArrayList<Student> loaded = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    loaded.add(Student.fromFileLine(line));
                }
            }
        } catch (IllegalArgumentException e) {      // «битая» строка в файле
            throw new IOException(e.getMessage());
        }
        // файл прочитан полностью - теперь можно заменить содержимое списка
        clear();
        for (Student student : loaded) {
            add(student);
        }
    }
}