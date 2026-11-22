package ru.mirea.task19;

import java.util.Arrays;

public class LabClass {
    // массив интерфейсных ссылок
    private StudentInfo[] students = new StudentInfo[4];
    private int count = 0;

    public void add(StudentInfo student) {
        if (count == students.length) {
            students = Arrays.copyOf(students, students.length * 2);
        }
        students[count++] = student;
    }

    public int size() {
        return count;
    }

    public StudentInfo[] getStudents() {
        return Arrays.copyOf(students, count);
    }

    // сортировка по среднему баллу (быстрая, по убыванию)
    public void sortByAverageMark() {
        quickSort(0, count - 1);
    }

    private void quickSort(int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        double pivot = students[(lo + hi) >>> 1].getAverageMark();
        int i = lo;
        int j = hi;
        while (i <= j) {
            while (students[i].getAverageMark() > pivot) {
                i++;
            }
            while (students[j].getAverageMark() < pivot) {
                j--;
            }
            if (i <= j) {
                StudentInfo tmp = students[i];
                students[i] = students[j];
                students[j] = tmp;
                i++;
                j--;
            }
        }
        quickSort(lo, j);
        quickSort(i, hi);
    }

    // поиск по ФИО, если не нашли - своё исключение
    public StudentInfo findByFullName(String fullName)
            throws EmptyStringException, StudentNotFoundException {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new EmptyStringException("Для поиска нужно ввести ФИО");
        }
        String wanted = fullName.trim();
        for (int i = 0; i < count; i++) {
            if (students[i].getFullName().equalsIgnoreCase(wanted)) {
                return students[i];
            }
        }
        throw new StudentNotFoundException("Студент не найден: " + wanted);
    }
}