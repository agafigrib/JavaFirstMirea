package ru.mirea.task19;

// исключение для пустой строки
public class EmptyStringException extends Exception {
    private static final long serialVersionUID = 1L;

    public EmptyStringException(String errorMessage) {
        super(errorMessage);
    }

    public EmptyStringException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}