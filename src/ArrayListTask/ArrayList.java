package ArrayListTask;

import java.util.StringJoiner;

public class ArrayList implements List {
    static final int INITIAL_CAPACITY = 5;

    Object[] array;
    int size;

    public ArrayList() {
        this(INITIAL_CAPACITY);
    }

    public ArrayList(int capacity) {
        array = new Object[capacity];
    }

    public void add(Object value) {
        if (size == array.length) {
          ///  Object[] new array[array.length + 1]
            System.arraycopy(array, 0, array, 0, array.length- 1);
        }
        array[size] = value;
        size++;

    }

    public void add(Object value, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, 0, array, index + 1, array.length);
        array[index] = value;
        size++;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object elementOfArray = array[index];
        return elementOfArray;
    }

    public Object set(Object value, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return null;
    }

    public void clear() {

    }


    public int size() {
        return 0;
    }


    public boolean isEmpty() {
        return false;
    }


    public boolean contains(Object value) {
        return false;
    }


    public int indexOf(Object value) {
        return 0;
    }


    public int lastIndexOf(Object value) {
        return 0;
    }


    public Object remove(int index) {
        return null;
    }

    // [A, B, C]
    public String toString() {
            StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (int i = 0; i < array.length; i++) {
            stringJoiner.add(array[i].toString());
        }
        return stringJoiner.toString();
    }


}



