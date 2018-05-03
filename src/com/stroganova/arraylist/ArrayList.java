package com.stroganova.arraylist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringJoiner;

public class ArrayList implements List {
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
        validateIndexForAdd(index);
        if (size == array.length) {
            array = Arrays.copyOf(array, (int) (array.length * 1.5) + 1);
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    public Object get(int index) {
        validateIndex(index);
        return array[index];
    }

    public Object set(Object value, int index) {
        validateIndex(index);
        Object beforeUpdating = array[index];
        array[index] = value;
        return beforeUpdating;
    }

    public Object remove(int index) {
        validateIndex(index);
        Object removed = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;
        return removed;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
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
        if (value == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (value.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        if (value == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (value.equals(array[i])) {
                    return i;
                }
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

    private void validateIndex(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty, size is " + size);
        } else if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is " + index + ". It should be between 0 and " + size + "(exclusive).");
        }
    }

    private void validateIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is " + index + ". For adding the index should be between 0 and " + size + "(inclusive).");
        }
    }

    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {
        private int index;

        public boolean hasNext() {
            return index < size;
        }

        public Object next() {
            return array[index++];
        }
    }
}





