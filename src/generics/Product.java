package generics;

/**
 * Created by YONA on 27.04.2018.
 */
public class Product<T extends Product<T>> implements Comparable<T> {
    String name;
    int price;

    public int compareTo(T o) {
        int result = 0;
        if (this.price > o.price) {
        result = 1;
        } else if (this.price < o.price) {
            result = -1;
        }
        return  result;
    }

     void subCompare(T p) {};
}
