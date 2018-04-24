package EmployeeService;

public abstract class Employee {
    long id;
    String name;
    double salary;
    int age;
    String gender;

    public abstract double getSalary();

    @Override
    public String toString() {
        return getClass().getName()
                + " [id = " + id
                + ", name = " + name
                + ", salary = " + getSalary()
                + ", age = " + age
                + ", gender = " + gender;
    }
}
