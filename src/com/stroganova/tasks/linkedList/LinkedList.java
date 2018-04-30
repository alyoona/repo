package com.stroganova.tasks.linkedList;

import java.util.*;

public class LinkedList {

    private int size = 0;
    private Node head;

    public void add(Object value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            size++;
        } else {
            Node current = head;
            while (current.next != null) {
                current.last = current;
                current = current.next;
            }
            current.next = newNode;
            newNode.last = current;
        }
    }





     class Node {
        Object value;
        Node last;
        Node next;
        public Node(Object value) {
            this.value = value;
        }
    }

    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        Node current = head;
        while (current != null) {
            stringJoiner.add(current.value.toString());
            current = current.next;
        }
        return stringJoiner.toString();
    }
}
