package StackQueue;

public class ArrayQueue {

    Object[] array;
    int size;

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

    }

    Object dequeue() {
        Object item = null;
        if (size != 0) {
            item = array[0];
            Object[] newArray = new Object[array.length];
            size--;
            for (int i = 0; i < array.length - 1 ; i++) {
                newArray[i] = array[i + 1];
            }
            array = newArray;
        } else {
                System.out.println("Queue is empty");}
        return item;
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

