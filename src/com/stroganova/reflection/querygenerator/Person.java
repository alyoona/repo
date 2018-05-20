package com.stroganova.reflection.querygenerator;


import com.stroganova.reflection.querygenerator.Column;
import com.stroganova.reflection.querygenerator.Table;

@Table(name = "Persons")
public class Person {
    @Column(name = "person_id", isPK = true)
    private int id;

    @Column
    private String name;

    @Column(name = "person_salary")
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
