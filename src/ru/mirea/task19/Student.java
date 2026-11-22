package ru.mirea.task19;

public class Student implements StudentInfo {
    private final String fullName;
    private final double averageMark;

    // проверяем ФИО и балл
    public Student(String fullName, double averageMark) throws EmptyStringException {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new EmptyStringException("ФИО студента не может быть пустым");
        }
        if (averageMark < 0 || averageMark > 5) {
            throw new IllegalArgumentException("Средний балл должен быть от 0 до 5: " + averageMark);
        }
        this.fullName = fullName.trim();
        this.averageMark = averageMark;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public double getAverageMark() {
        return averageMark;
    }

    @Override
    public String toString() {
        return String.format("%-30s %.2f", fullName, averageMark);
    }
}
