package ru.mirea.task19;

public class OnlineOrder {
    private final String fullName;
    private final String inn;

    // при создании заказа проверяем ФИО и ИНН
    public OnlineOrder(String fullName, String inn) throws InvalidInnException {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("ФИО не введено");
        }
        InnValidator.validate(inn);
        this.fullName = fullName.trim();
        this.inn = inn;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInn() {
        return inn;
    }

    @Override
    public String toString() {
        return "Заказ оформлен: " + fullName + ", ИНН " + inn;
    }
}