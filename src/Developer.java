
public class Developer extends Employee {


    int fixedBugs = 0;
    int rate = 0;
    boolean randomBoolean = false;


    double getSalary() {
        return (super.getSalary() + fixedBugs*50)*(randomBoolean ? 2 : 0);
    }
}
