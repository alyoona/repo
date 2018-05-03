package com.stroganova.employeeservice;

public class Manager extends Employee {

    public double getSalary() {
        return super.salary;
    }

    public String toString() {
        return super.toString()
                + "]";
    }

}
