import java.util.Random;

public class EmploeeServiceTwo {

   private Employee[] employeeArray;
   Random random = new Random();
   String randomEmploees = "dmc";

   void generateEmployees(int size) {
        for (int i = 0; i < employeeArray.length ; i++) {
            Developer developer = new Developer();
            Manager manager = new Manager();
            Cleaner cleaner = new Cleaner();
            char emploType = randomEmploees.charAt(random.nextInt(randomEmploees.length()));
            if (emploType == 'd') {
                employeeArray[i] = developer;
            } else if(emploType == 'm') {
                employeeArray[i] = manager;
            } else {
                employeeArray[i] = cleaner;
            }

            int fixedBugs = random.nextInt(10);
            int rate = random.nextInt(50);
            boolean randomBoolean = random.nextBoolean();
            int workedDays = random.nextInt(20);

        }

    }

}
