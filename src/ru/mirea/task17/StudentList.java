package ru.mirea.task17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


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
        FileWriter writer = new FileWriter(fileName);
        for (int i = 1; i <= size(); i++) {
            writer.write(get(i).toFileLine() + "\n");
        }
        writer.close();
    }

    //  список из файла (старое содержимое удаляется)
    default void loadFromFile(String fileName) throws IOException {
        clear();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.isEmpty()) {
                add(Student.fromFileLine(line));
            }
        }
        reader.close();
    }
}