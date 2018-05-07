package com.stroganova.arraylist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringJoiner;
import java.util.ArrayList;

public class ArrayListGenerics<E> implements List<E> {
    static final int INITIAL_CAPACITY = 5;
    private Object[] array;
    private int size;

    public ArrayListGenerics() {
        this(INITIAL_CAPACITY);
    }

    public ArrayListGenerics(int capacity) {
        array = new Object[capacity];
    }

    public void add(E value) {
        add(value, size);
    }

    public void add(E value, int index) {
        validateIndexForAdd(index);
        if (size == array.length) {
            array = Arrays.copyOf(array, (int) (array.length * 1.5) + 1);
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    public E get(int index) {
        validateIndex(index);
        E result = (E) array[index];
        return result;
    }

    public E set(E value, int index) {
        validateIndex(index);
        E beforeUpdating = (E) array[index];
        array[index] = value;
        return beforeUpdating;
    }

    public E remove(int index) {
        validateIndex(index);
        E removed = (E) array[index];
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

    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    public int indexOf(E value) {
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

    public int lastIndexOf(E value) {
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

    public Iterator <E> iterator() {
        return new MyIterator<E>();
    }

    private class MyIterator<E> implements Iterator<E> {
        private int index;

        public boolean hasNext() {
            return index < size;
        }

        public E next() {
            E result = (E) array[index++];
            return result;
        }
    }
}






