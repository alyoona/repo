package MockEmployeeGenerator;

public class EmployeeService {
    /*

    MockEmployeeGenerator.MockEmployeeGenerator.EmployeeService.Employee[] employees;
    MockEmployeeGenerator.MockEmployeeGenerator.EmployeeService.Employee employee;

    MockEmployeeGenerator.MockEmployeeGenerator.EmployeeService.Employee getById(long id) {
        employee = new MockEmployeeGenerator.MockEmployeeGenerator.EmployeeService.Employee();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].id == id) {
                employee = employees[i];
            }
        }
        return employee;
    }

    MockEmployeeGenerator.MockEmployeeGenerator.EmployeeService.Employee[] findByFirstName(String firstName) {
        MockEmployeeGenerator.MockEmployeeGenerator.EmployeeService.Employee[] employeesByFirstName = new MockEmployeeGenerator.MockEmployeeGenerator.EmployeeService.Employee[employees.length];
        int j = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].firstName == firstName) {
                employeesByFirstName[j] = employees[i];
                j++;
            }
        }
        return employeesByFirstName;
    }

    MockEmployeeGenerator.MockEmployeeGenerator.EmployeeService.Employee[] sortByFirstName() {
        for (int i = 0; i < employees.length - 1; i++) {
            for (int j = i + 1; j < employees.length; j++) {

                if (employees[i].firstName.charAt(0) > employees[j].firstName.charAt(0)) {
                    MockEmployeeGenerator.MockEmployeeGenerator.EmployeeService.Employee buffer = employees[i];
                    employees[i] = employees[j];
                    employees[j] = buffer;
                }
            }
        }
        return employees;
    }

    void update(MockEmployeeGenerator.MockEmployeeGenerator.EmployeeService.Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].id == newEmployee.id) {
                employees[i] = newEmployee;
            }
        }
    }

    void delete(MockEmployeeGenerator.MockEmployeeGenerator.EmployeeService.Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].id == newEmployee.id) {
                employees[i] = new MockEmployeeGenerator.MockEmployeeGenerator.EmployeeService.Employee(0, null, null, 0, 0);
            }
        }
    }

    void print(MockEmployeeGenerator.MockEmployeeGenerator.EmployeeService.Employee[] employees) {
        for (MockEmployeeGenerator.MockEmployeeGenerator.EmployeeService.Employee employee : employees) {
            if (employee.id != 0) {
                System.out.println(employee.id + " " + employee.firstName + " " + employee.lastName + " " + employee.age + " " + employee.salary);
            }
        }
    }

    void print(MockEmployeeGenerator.MockEmployeeGenerator.EmployeeService.Employee employee) {
        System.out.println(employee.id + " " + employee.firstName + " " + employee.lastName + " " + employee.age + " " + employee.salary);
    }
*/

}
