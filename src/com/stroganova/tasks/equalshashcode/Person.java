package com.stroganova.tasks.equalshashcode;

import java.util.Objects;

public class Person {

    private String name;
    private double salary;
    int age;
   // Phone[] phones;

    public Person (String newName, double newSalary, int newAge) {
        name = newName;
        salary = newSalary;
        age = newAge;
    }
    @Override
    public boolean equals(Object otherPerson) {
        if (this == otherPerson) {
            return true;
        }
        if (otherPerson instanceof Person) {
            Person that = (Person) otherPerson;
           if (name.equals(that.name)
                    && Double.compare(salary, that.salary) == 0
                    && age == that.age
                    ) {
                return true;
            }
        }
        return false;
    }
}









/*                if(Objects.equals(name, that.name)
                        && Double.compare(salary, that.salary) == 0
                        && age == that.age
                        )
                {
                    return true;
                }*/

