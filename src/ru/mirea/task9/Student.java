package ru.mirea.task9;

public class Student implements Comparable<Student> {
    private int iDNumber;        // номер студенческого билета
    private String firstName;
    private String lastName;
    private double gpa;          // средний балл

    public Student(int iDNumber, String firstName, String lastName, double gpa) {
        this.iDNumber = iDNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
    }

    public int getIDNumber() { return iDNumber; }
    public void setIDNumber(int iDNumber) { this.iDNumber = iDNumber; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    // отрицательное - этот студент раньше, положительное - позже, 0 - равны
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.iDNumber, other.iDNumber);
    }

    @Override
    public String toString() {
        return iDNumber + " | " + lastName + " " + firstName + " | " + gpa;
    }
}
