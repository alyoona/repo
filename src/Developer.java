import java.util.Random;

public class Developer extends Employee {


    int fixedBugs = 0;
    static final int COEFFICIENT = 100;
    boolean randomBoolean = new Random().nextBoolean();

    public double getSalary() {
        return (super.salary + fixedBugs * COEFFICIENT) * (randomBoolean ? 2 : 0);
    }

    public String toString() {
        return super.toString()
                + ", fixedBugs = " + fixedBugs
                + "]";
    }
}
