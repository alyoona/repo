package StackQueue;

public class ArrayQueue {

    Object[] array;
    int size;
    int start = 0;
    int end = 0;

    public ArrayQueue() {
        array = new Object[2];
    }

    public Object[] grow(Object[] array) {
        Object[] newArray = new Object[(int) (1.5 * array.length)];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    void enqueue(Object value) {
        if (size == array.length) {
            array = grow(array);
        }

        array[size] = value;
        size++;
        start++;
        if(start == 0) {
            end++;
        }
    }

    Object dequeue() {
        return null;
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

