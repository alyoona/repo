package EmployeeService;

public class Manager extends EmployeeService.Employee {

    public double getSalary() {
        return super.salary;
    }

    public String toString() {
        return super.toString()
                + "]";
    }

}
