package com.stroganova.mockemployeegenerator;

public class MockEmployeeGenerator {
/*

    static String[] firstNames = {"Александр","Алексей","Андрей","Артем","Арсений","Владислав","Денис","Дмитрий","Евгений","Егор","Иван","Игорь","Илья","Кирилл","Максим","Матвей","Михаил","Никита","Роман","Руслан","Сергей","Тимофей","Тимур","Ярослав"};
    static String[] lastNames = {"Иванов","Смирнов","Кузнецов","Попов","Васильев","Петров","Соколов","Михайлов","Новиков","Федоров","Морозов","Волков","Алексеев","Лебедев","Семенов","Егоров","Павлов","Козлов","Степанов","Николаев","Орлов","Андреев","Макаров","Никитин","Захаров","Зайцев","Соловьев","Борисов","Яковлев","Григорьев"};
    String genderFlags = "mfo";
    Random random = new Random();



        Employee[] generateEmployees(int size) {
        Employee[] employees = new Employee[size];
        long id =  (long) (Math.random() * size);
        for (int i = 0; i < size; i++) {
            id++;
            int age = (int) ((Math.random() * (60 - 18 + 1)) + 18);
            double salary = Math.round(Math.random() * (1000 - 300) + 300);
            String firstName = firstNames[ (int) (firstNames.length * Math.random())];
            String lastName = lastNames[ (int) (firstNames.length * Math.random())];
            String name = firstName + " " + lastName;
            char randomGender = genderFlags.charAt(random.nextInt(genderFlags.length()));
            String gender;
            if (randomGender == 'm') {
                gender = "male";
            } else if (randomGender == 'f') {
                gender = "female";
            } else {
                gender = "other";
            }


            com.stroganova.tasks.mockemployeegenerator.com.stroganova.tasks.mockemployeegenerator.com.stroganova.tasks.employeeservice.Employee employee = new com.stroganova.tasks.mockemployeegenerator.com.stroganova.tasks.mockemployeegenerator.com.stroganova.tasks.employeeservice.Employee();
            employee.id = id;
            employee.name = name;
            employee.age = age;
            employee.salary = salary;
            employee.gender = gender;

            employees[i] = employee;

        }
        return employees;
    }

*/
}
