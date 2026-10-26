package ru.mirea.task13;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;

    public Person(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    private static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    // Фамилия И.О. с учётом отсутствия имени и/или отчества
    public String getShortName() {
        // StringBuilder быстрее, чем конкатенация через +
        StringBuilder sb = new StringBuilder(lastName);
        boolean hasFirst = !isEmpty(firstName);
        boolean hasMiddle = !isEmpty(middleName);

        if (hasFirst || hasMiddle) {
            sb.append(' ');
        }
        if (hasFirst) {
            sb.append(firstName.trim().charAt(0)).append('.');
        }
        if (hasMiddle) {
            sb.append(middleName.trim().charAt(0)).append('.');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Person("Иванов", "Иван", "Иванович").getShortName());
        System.out.println(new Person("Петров", "Пётр", null).getShortName());
        System.out.println(new Person("Сидоров", null, null).getShortName());
        System.out.println(new Person("Козлов", "", "Олегович").getShortName());
    }
}