import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class EmploeeServiceTwo {

    Employee[] employeesArray;
    Random random = new Random();
    String employeeFlags = "dmc";
    String genderFlags = "mfo";
    static String[] firstNames = {"Александр", "Алексей"};//, "Андрей", "Артем", "Арсений", "Владислав", "Денис", "Дмитрий", "Евгений", "Егор", "Иван", "Игорь", "Илья", "Кирилл", "Максим", "Матвей", "Михаил", "Никита", "Роман", "Руслан", "Сергей", "Тимофей", "Тимур", "Ярослав"};
    static String[] lastNames = {"Иванов", "Смирнов"};//, "Кузнецов", "Попов", "Васильев", "Петров", "Соколов", "Михайлов", "Новиков", "Федоров", "Морозов", "Волков", "Алексеев", "Лебедев", "Семенов", "Егоров", "Павлов", "Козлов", "Степанов", "Николаев", "Орлов", "Андреев", "Макаров", "Никитин", "Захаров", "Зайцев", "Соловьев", "Борисов", "Яковлев", "Григорьев"};

    void generateEmployees(int size) {

        long id = (long) random.nextInt(size);
        employeesArray = new Employee[size];
        for (int i = 0; i < employeesArray.length; i++) {
            id++;
            char employeeType = employeeFlags.charAt(random.nextInt(employeeFlags.length()));
            if (employeeType == 'd') {
                Developer developer = new Developer();
                fillCommonFields(developer, id);
                developer.fixedBugs = random.nextInt(101);
                employeesArray[i] = developer;

            } else if (employeeType == 'm') {
                Manager manager = new Manager();
                fillCommonFields(manager, id);
                employeesArray[i] = manager;

            } else {
                Cleaner cleaner = new Cleaner();
                fillCommonFields(cleaner, id);
                cleaner.rate = random.nextInt(51) + 1000;
                cleaner.workedDays = getWorkedDaysOfCurrentMonth();
                employeesArray[i] = cleaner;
            }
        }
    }

    void fillCommonFields(Employee employee, long id) {
        employee.id = id;
        int i = random.nextInt(firstNames.length);
        int j = random.nextInt(lastNames.length);
        employee.name = firstNames[i] + " " + lastNames[j];
        employee.salary = Math.floor(random.nextDouble() * 5000 + 2000);
        employee.age = random.nextInt(42 + 1) + 18;
        employee.gender = "" + genderFlags.charAt(random.nextInt(genderFlags.length()));
    }

    void printEmployees() {
        for (Employee employee : employeesArray) {
            System.out.println(employee.toString());
        }
    }

    void printEmployees(Employee[] array) {
        for (Employee employee : array) {
            System.out.println(employee.toString());
        }
    }

    public int getWorkedDaysOfCurrentMonth() {
        GregorianCalendar calendar = new GregorianCalendar();
        int month = calendar.get(Calendar.MONTH);
        int nextMonth = 0;
        if (month < 12) {
            nextMonth = month + 1;
        }
        int count = 0;
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        while (month != nextMonth) {
            int weekday = calendar.get(Calendar.DAY_OF_WEEK);
            if (weekday != 7 && weekday != 1) {
                count++;
            }
            calendar.add(Calendar.DAY_OF_MONTH, +1);
            month = calendar.get(Calendar.MONTH);
        }
        return count;
    }

    double calculateSalaryAndBonus() {
        double result = 0;
        for (int i = 0; i < employeesArray.length; i++) {
            result += employeesArray[i].getSalary();
        }
        return result;
    }

    Employee getById(long id) {
        int i;
        for (i = 0; i < employeesArray.length; i++) {
            if (employeesArray[i].id == id) {
                break;
            }
        }
        return employeesArray[i];
    }

    Employee[] getByName(String name) {
        int newLength = 0;
        for (int i = 0; i < employeesArray.length; i++) {
            if (name.equals(employeesArray[i].name)) {
                newLength++;
            }
        }
        Employee[] employeesByName = new Employee[newLength];
        int j = 0;
        for (int i = 0; i < employeesArray.length; i++) {
            if (name.equals(employeesArray[i].name)) {
                employeesByName[j] = employeesArray[i];
                j++;
            }
        }
        return employeesByName;
    }

    Employee[] sortByName() {
        for (int i = 0; i < employeesArray.length - 1; i++) {
            for (int j = i + 1; j < employeesArray.length; j++) {

                if (employeesArray[i].name.compareTo(employeesArray[j].name) > 0) {
                    Employee buffer = employeesArray[i];
                    employeesArray[i] = employeesArray[j];
                    employeesArray[j] = buffer;
                }
            }
        }
        return employeesArray;
    }

    Employee[] sortByNameAndSalary() {
        sortByName();
        for (int i = 0; i < employeesArray.length - 1; i++) {
            for (int j = i + 1; j < employeesArray.length; j++) {
                if (employeesArray[i].name.compareTo(employeesArray[j].name) == 0
                    && Double.compare(employeesArray[i].getSalary(), employeesArray[j].getSalary()) > 0) {
                    Employee buffer = employeesArray[i];
                    employeesArray[i] = employeesArray[j];
                    employeesArray[j] = buffer;
                }
            }
        }
        return employeesArray;
    }

    Employee edit(Employee employee) {
        return  null;
    }
}
