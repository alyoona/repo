public abstract class Employee {
    long id;
    String name;
    double salary;
    int age;
    String gender;

    public abstract double getSalary();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (Double.compare(employee.salary, salary) != 0) return false;
        if (age != employee.age) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return gender != null ? gender.equals(employee.gender) : employee.gender == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + age;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

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
