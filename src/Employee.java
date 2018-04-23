public class Employee {
    long id;
    public String name;
    double salary;
    int age;
    String gender;

    Employee() {

    }

    void printInfo() {
        System.out.print("id = " + id);
        System.out.print(", name = " + name);
        System.out.print(", salary = " + salary);
        System.out.println(", age = " + age);
    }

    double calculateBonus() {
        return salary * Math.random() * age;
    }

    double getSalary() {
        return salary;
    }
}
