package ru.mirea.task19;

// своё проверяемое исключение (наследуемся от Exception)
public class InvalidInnException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidInnException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidInnException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}