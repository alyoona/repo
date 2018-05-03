package com.stroganova.linkedstackqueue;

/**
 * Created by dp-ptcstd-15 on 4/24/2018.
 */
public class LinkedStack {

    Node firstOut;

    public void push(Object value) {
        Node newNode = new Node(value);
        if (firstOut == null) {
            firstOut = newNode;
        } else {
            newNode.next = firstOut;
            firstOut = newNode;
        }
    }

    public Object pop() {
        Object valueToReturn = firstOut.value;
        firstOut = firstOut.next;
        return valueToReturn;
    }

    public String toString() {
        StringBuilder bilder = new StringBuilder();
        bilder.append("]");
        while (firstOut.next != null) {
            bilder.append(firstOut.value.toString());
            firstOut = firstOut.next;
            if (firstOut.next == null) {
                bilder.append(" ,");
                bilder.append(firstOut.value.toString());
            } else {
                bilder.append(" ,");
            }
        }
        bilder.append("[");
        return bilder.reverse().toString();
    }

}
