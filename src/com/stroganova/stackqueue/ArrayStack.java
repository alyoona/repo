package com.stroganova.stackqueue;

/**
 * Created by dp-ptcstd-15 on 4/19/2018.
 */
public class ArrayStack {
    Object[] array;
    int size;

    public ArrayStack() {
        array = new Object[2];
    }

    void push(Object value) {
        if (size == array.length) {
            // g row
            Object[] newArray = new Object[(int) (1.5 * array.length)];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }

        array[size] = value;
        size++;
    }

    Object pop() {
        Object result = array[size - 1];
        size--;
        return result;
    }

    Object peek() {
        return array[size - 1];
    }

    int size() {
        return size;
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += array[i];
            if (i != size - 1) {
                result += ", ";
            }
        }
        return result + "]";
    }
}

