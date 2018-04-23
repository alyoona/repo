/**
 * Created by dp-ptcstd-15 on 4/19/2018.
 */
public class Cleaner extends Employee {
    int rate;
    int workedDays;

    double getSalary() {
        return (super.getSalary() + rate * workedDays);
    }
}
