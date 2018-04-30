package com.stroganova.tasks.arraylist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringJoiner;

public class ArrayList implements List, Iterable {
    static final int INITIAL_CAPACITY = 5;

    private Object[] array;
    private int size;

    public ArrayList() {
        this(INITIAL_CAPACITY);
    }

    public ArrayList(int capacity) {
        array = new Object[capacity];
    }

    public void add(Object value) {
        add(value, size);
    }

    public void add(Object value, int index) {
        validation(value);
        validation(index, "add");
        if (size == array.length) {
            array = Arrays.copyOf(array, (int) (array.length * 1.5));
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    public Object get(int index) {
        validation(index, "get");
        Object elementOfArray = array[index];
        return elementOfArray;
    }

    public Object set(Object value, int index) {
        validation(value);
        validation(index, "set");
        Object beforeUpdating = array[index];
        array[index] = value;
        return beforeUpdating;
    }

    public Object remove(int index) {
        validation(index, "remove");
        Object removed = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;

        return removed;
    }

    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            stringJoiner.add(String.valueOf(array[i]));
        }
        return stringJoiner.toString();
    }

    private void validation(Object value) {
        if (value == null) {
            throw new NullPointerException("Null value should not be contained");
        }
    }

    private void validation(int index, String action) {
        if (action == "add") {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index is " + index + ". For adding the index should be between 0" + " and " + size + "(inclusive).");
            }
        } else if (isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty, size is " + size + ", there is nothing to " + action + ".");
        } else {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index is " + index + ". It should be between 0" + " and " + size + "(exclusive) in order to " + action + " value.");
            }
        }

    }

    public Iterator iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator {
        int index;

        public boolean hasNext() {
            return index < size;
        }

        public Object next() {
            return array[index++];
        }
    }
}





