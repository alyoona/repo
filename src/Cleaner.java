/**
 * Created by dp-ptcstd-15 on 4/19/2018.
 */
public class Cleaner extends Employee {
    int rate;
    int workedDays;

    public double getSalary() {
        return (super.salary + rate * workedDays);
    }
    public String toString() {
        return super.toString()
                + ", rate = " + rate
                + ", workedDays = " + workedDays
                + "]";
    }


}
