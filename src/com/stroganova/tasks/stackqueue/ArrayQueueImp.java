package com.stroganova.tasks.stackqueue;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Created by YONA on 24.04.2018.
 */
public class ArrayQueueImp {
    Object[] array;
    int size;
    int start = 0;

     int end = 0;

    public ArrayQueueImp() {
        array = new Object[2];
        Arrays.fill(array,null);
    }

    public Object[] grow(Object[] array) {
        Object[] newArray = new Object[(int) (1.5 * array.length)];
        int length = newArray.length;
        if (end == start - 1){
            length = newArray.length;
            for (int i = 0; i < start; i++) {
                newArray[i] = array[i];
            }
            length = newArray.length;
            for (int j = newArray.length; j >= newArray.length - start ; j--) {
                newArray[j] = array[j];
            }
        } else {
            length = newArray.length;
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
        }
        return newArray;
    }

    Object dequeue() {
        Object item = null;
        if ( ! isEmptyQueue() ) {
            item = array[start];
            size--;
            array[start] = null;
            if(start < array.length){
                start++;
            } else {
                start = 0;
            }
        } else {
            System.out.println("Queue is empty");
        }
        return item;
    }

    void enqueue(Object value) {
        if (size == array.length) {
            array = grow(array);
        }
        if ( isThereAnEmptyCell() ) {
            if ( isEmptyQueue() ) {
                array[end] = value;
                end++;
                size++;
            } else if (end > 0 && end < array.length) {
                array[end] = value;
                end++;
                size++;
            } else if (end == array.length) {
                    for (int i = 0; i < start; i++) {
                         if (array[i] == null){
                            end = i;
                            array[end] = value;
                            size++;
                            break;
                         }
                    }
            }
        }
    }

    private boolean isEmptyQueue() {
        return  size == 0;
    }

    private boolean isThereAnEmptyCell() {
        return  size < array.length;
    }

    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < array.length; i++) {
            stringJoiner.add((String) array[i]);
        }
        return stringJoiner.toString();
    }
}
