package ru.mirea.task19;

// исключение, если студента нет в списке
public class StudentNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public StudentNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public StudentNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}