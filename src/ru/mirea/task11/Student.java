package ru.mirea.task11;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Student {
    private String firstName;
    private String lastName;
    private String specialty;
    private int course;
    private String group;
    private Date birthDate;   // новое поле

    public Student(String firstName, String lastName, String specialty,
                   int course, String group, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.course = course;
        this.group = group;
        this.birthDate = birthDate;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public int getCourse() { return course; }
    public void setCourse(int course) { this.course = course; }
    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }
    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    // дата рождения по шаблону, например "dd.MM.yyyy" или "d MMMM yyyy"
    public String getBirthDateString(String pattern) {
        return new SimpleDateFormat(pattern, new Locale("ru")).format(birthDate);
    }

    // дата рождения в стандартном формате: DateFormat.SHORT, MEDIUM, LONG или FULL
    public String getBirthDateString(int style) {
        return DateFormat.getDateInstance(style, new Locale("ru")).format(birthDate);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " | " + specialty + " | "
                + course + " курс | " + group + " | дата рождения: "
                + getBirthDateString(DateFormat.MEDIUM);
    }
}