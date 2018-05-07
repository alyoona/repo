package com.stroganova.linkedlist;

import java.util.*;

public class LinkedList implements List {
    private int size;
    private Node head;
    private Node tail;

    public void add(Object value) {
        add(value, size);
    }

    public void add(Object value, int index) {
        validateIndexForAdd(index);
        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (size == index) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node current = getNode(index);
            Node previous = current.prev;
            previous.next = newNode;
            newNode.prev = previous;
            newNode.next = current;
            current.prev = newNode;
        }
        size++;
    }

    public Object remove(int index) {
        validateIndex(index);
        Node current = getNode(index);
        Object removed = current.value;
        if (size == 1) {
            tail = head = null;
        } else if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node previous = current.prev;
            previous.next = current.next;
            current.next = null;
            current.prev = null;
            current = previous.next;
            current.prev = previous;
        }
        size--;
        return removed;
    }

    public Object get(int index) {
        validateIndex(index);
        return getNode(index).value;
    }

    public Object set(Object value, int index) {
        validateIndex(index);
        Object beforeUpdating = getNode(index).value;
        getNode(index).value = value;
        return beforeUpdating;
    }

    public void clear() {
        tail = head = null;
        size = 0;
    }

    public int indexOf(Object value) {
        Node current = head;
        if (value == null) {
            for (int i = 0; i < size; i++) {
                if (current.value == null) {
                    return i;
                }
                current = current.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (value.equals(current.value)) {
                    return i;
                }
                current = current.next;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        Node current = tail;
        if (value == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (current.value == null) {
                    return i;
                }
                current = current.prev;
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (value.equals(current.value)) {
                    return i;
                }
                current = current.prev;
            }
        }
        return -1;
    }

    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        Node current = head;
        while (current != null) {
            stringJoiner.add(String.valueOf(current.value));
            current = current.next;
        }
        return stringJoiner.toString();
    }


    private void validateIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is " + index + ". For adding the index should be between 0 and " + size + "(inclusive).");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is " + index + ". It should be between 0 and " + size + "(exclusive).");
        }
    }

    private Node getNode(int index) {
        Node current = head;
        for (int i = 1; i <= index; i++) {
                current = current.next;
        }
        return current;
    }

    private static class Node {
        private Object value;
        private Node prev;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }
    }

    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {
        Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public Object next() {
            Object result = current.value;
            current = current.next;
            return result;
        }
    }
}
