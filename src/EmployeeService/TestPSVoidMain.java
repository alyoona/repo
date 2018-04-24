package EmployeeService;

public class TestPSVoidMain {

    public static void main(String[] args) {
        EmploeeService service = new EmploeeService();

        service.generateEmployees(2);
        //service.printEmployees();
        //System.out.println(service.calculateSalaryAndBonus());

        //System.out.println(service.getById(2));
        //service.getByName("Алексей");
        System.out.println();

        //MockEmployeeGenerator.MockEmployeeGenerator.EmployeeService.Employee[] emp = service.getByName("Алексей Иванов");
        //service.printEmployees(emp);

        //MockEmployeeGenerator.MockEmployeeGenerator.EmployeeService.Employee[] emp2 = service.sortByName();
        //service.printEmployees(emp2);

        //MockEmployeeGenerator.MockEmployeeGenerator.EmployeeService.Employee[] emp3 = service.sortByNameAndSalary();
        //service.printEmployees(emp3);

        System.out.println();
        Developer developer = new Developer();
        developer.id = 2;
        developer.fixedBugs = 500;

        System.out.println(service.getById(2));

        service.edit(developer);

        System.out.println();
        System.out.println(service.getById(2));





    }

}
