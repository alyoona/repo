package com.stroganova.tasks.employeeservice;

public class Manager extends com.stroganova.tasks.employeeservice.Employee {

    public double getSalary() {
        return super.salary;
    }

    public String toString() {
        return super.toString()
                + "]";
    }

}
