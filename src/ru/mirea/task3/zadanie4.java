package ru.mirea.task3;




    class Employee {
        String fullname;
        double salary;

        Employee(String fullname, double salary) {
            this.fullname = fullname;
            this.salary = salary;
        }
    }

    class Report {

        static void generateReport(Employee[] employees) {

            for (int i = 0; i < employees.length; i++) {

                System.out.printf(
                        "%-20s %10.2f%n",
                        employees[i].fullname,
                        employees[i].salary
                );
            }
        }
    }
    public class zadanie4 {
        public static void main(String[] args) {

            Employee[] employees = {
                    new Employee("Иван Иванов", 50000),
                    new Employee("Пётр Петров", 60000),
                    new Employee("Анна Сидорова", 70000)
            };

            Report.generateReport(employees);
        }
    }

