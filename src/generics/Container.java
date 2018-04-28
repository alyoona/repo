package generics;

/**
 * Created by YONA on 27.04.2018.
 */
public class Container<T extends Product> {

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    T item;

}
