import java.util.*;

public class MockEmployeeGenerator {


    String[] firstNmes = {"Александр","Алексей","Андрей","Артем","Арсений","Владислав","Денис","Дмитрий","Евгений","Егор","Иван","Игорь","Илья","Кирилл","Максим","Матвей","Михаил","Никита","Роман","Руслан","Сергей","Тимофей","Тимур","Ярослав"};
    String[] lastNames = {"Иванов","Смирнов","Кузнецов","Попов","Васильев","Петров","Соколов","Михайлов","Новиков","Федоров","Морозов","Волков","Алексеев","Лебедев","Семенов","Егоров","Павлов","Козлов","Степанов","Николаев","Орлов","Андреев","Макаров","Никитин","Захаров","Зайцев","Соловьев","Борисов","Яковлев","Григорьев"};
    String chars = "mfo";
    Random random = new Random();



    Employee[] generateEmployees(int size) {
        Employee[] employees = new Employee[size];
        long id =  (long) (Math.random() * size);
        for (int i = 0; i < size; i++) {
            id++;
            int age = (int) ((Math.random() * (60 - 18 + 1)) + 18);
            double salary = Math.round(Math.random() * (1000 - 300) + 300);
            String firstName = firstNmes[ (int) (firstNmes.length * Math.random())];
            String lastName = lastNames[ (int) (firstNmes.length * Math.random())];
            String name = firstName + " " + lastName;
            char randomGender = chars.charAt(random.nextInt(chars.length()));
            String gender;
            if (randomGender == 'm') {
                gender = "male";
            } else if (randomGender == 'f') {
                gender = "female";
            } else {
                gender = "other";
            }


            Employee employee = new Employee();
            employee.id = id;
            employee.name = name;
            employee.age = age;
            employee.salary = salary;
            employee.gender = gender;

            employees[i] = employee;
        }
        return employees;


    }


}
