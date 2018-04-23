public class EmployeeService {
    /*

    Employee[] employees;
    Employee employee;

    Employee getById(long id) {
        employee = new Employee();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].id == id) {
                employee = employees[i];
            }
        }
        return employee;
    }

    Employee[] findByFirstName(String firstName) {
        Employee[] employeesByFirstName = new Employee[employees.length];
        int j = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].firstName == firstName) {
                employeesByFirstName[j] = employees[i];
                j++;
            }
        }
        return employeesByFirstName;
    }

    Employee[] sortByFirstName() {
        for (int i = 0; i < employees.length - 1; i++) {
            for (int j = i + 1; j < employees.length; j++) {

                if (employees[i].firstName.charAt(0) > employees[j].firstName.charAt(0)) {
                    Employee buffer = employees[i];
                    employees[i] = employees[j];
                    employees[j] = buffer;
                }
            }
        }
        return employees;
    }

    void update(Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].id == newEmployee.id) {
                employees[i] = newEmployee;
            }
        }
    }

    void delete(Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].id == newEmployee.id) {
                employees[i] = new Employee(0, null, null, 0, 0);
            }
        }
    }

    void print(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee.id != 0) {
                System.out.println(employee.id + " " + employee.firstName + " " + employee.lastName + " " + employee.age + " " + employee.salary);
            }
        }
    }

    void print(Employee employee) {
        System.out.println(employee.id + " " + employee.firstName + " " + employee.lastName + " " + employee.age + " " + employee.salary);
    }
*/

}
