package ArrayListTask;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class ArrayList implements List {
    static final int INITIAL_CAPACITY = 5;

    Object[] array;
    private int size;

    public ArrayList() {
        this(INITIAL_CAPACITY);
    }

    public ArrayList(int capacity) {
        array = new Object[capacity];
    }

    public void add(Object value) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length + 1);
        }
        array[size] = value;
        size++;
    }

    public void add(Object value, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length + 1);
        }
        System.arraycopy(array, index, array, index + 1, size - index);
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
        array[index] = value;
        Object updated = array[index];
        return updated;
    }

    public void clear() {
        array = Arrays.copyOf(array, 1);
        array[0] = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public int indexOf(Object value) {
        int result = 0;
        if (!contains(value)) {
            throw new NoSuchElementException("No such element");
        }
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                result = i;
                break;
            }
        }
        return result;
    }

    public int lastIndexOf(Object value) {
        int result = 0;
        if (!contains(value)) {
            throw new NoSuchElementException("No such element");
        }
        for (int i = size - 1; i >= 0; i++) {
            if (array[i].equals(value)) {
                result = i;
                break;
            }
        }
        return result;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("No such index");
        }
        Object removed = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return removed;
    }

    // [A, B, C]
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < array.length; i++) {
            stringJoiner.add(array[i].toString());
        }
        return stringJoiner.toString();
    }

}



