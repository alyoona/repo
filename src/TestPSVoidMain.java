import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

/**
 * Created by YONA on 23.04.2018.
 */
public class TestPSVoidMain {

    public static void main(String[] args) {
        EmploeeServiceTwo service = new EmploeeServiceTwo();

        service.generateEmployees(4);
        service.printEmployees();
        //System.out.println(service.calculateSalaryAndBonus());

        //System.out.println(service.getById(2));
        //service.getByName("Алексей");
        System.out.println();

        //Employee[] emp = service.getByName("Алексей Иванов");
        //service.printEmployees(emp);

        //Employee[] emp2 = service.sortByName();
        //service.printEmployees(emp2);

        Employee[] emp3 = service.sortByNameAndSalary();
        service.printEmployees(emp3);


    }

}
