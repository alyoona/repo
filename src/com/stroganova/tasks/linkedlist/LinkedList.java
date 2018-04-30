package com.stroganova.tasks.linkedlist;

import java.util.*;

public class LinkedList implements List {

    private int size = 0;
    private Node head;
    private Node tail;

    public void add(Object value) {
        add(value, size);
    }

    public void add(Object value, int index) {
        validateIndexForAdd(index);
        Node newNode = new Node(value);
        if (index == 0 && size == 0) {
            head = newNode;
            tail = head;
        } else if (size == index) {
            newNode.linkToPrevious = tail;
            tail.linkToNext = newNode;
            tail = tail.linkToNext;
        } else {
            Node current = head;
            Node previous = null;
            for (int i = 1; i <= index; i++) {
                previous = current;
                current = current.linkToNext;
                current.linkToPrevious = previous;
            }
            if (current.linkToPrevious != null) {
                previous.linkToNext = newNode;
                newNode.linkToNext = current;
                current.linkToPrevious = newNode;
                newNode.linkToPrevious = previous;

            } else {
                current.linkToPrevious = newNode;
                newNode.linkToNext = current;
                head = current.linkToPrevious;
            }
        }
        size++;
    }

    public Object remove(int index) {
        validateIndex(index);
        Node current = head;
        Node previous = null;
        for (int i = 1; i <= index; i++) {
            previous = current;
            current = current.linkToNext;
        }
        Object removed = current.value;
        current.value = null;
        size--;
        if (previous == null) {
            if (current.linkToNext == null) {
                head = null;
            } else {
                head = current.linkToNext;
                head.linkToPrevious = null;
                current.linkToNext = null;
            }
        } else if (current.linkToNext != null) {
            previous.linkToNext = current.linkToNext;
            current.linkToNext = null;
            current.linkToPrevious = null;
            current = previous.linkToNext;
            current.linkToPrevious = previous;
        } else {
            tail = current.linkToPrevious;
            current.linkToPrevious = null;
            tail.linkToNext = null;
        }
        return removed;
    }

    public Object get(int index) {
        validateIndex(index);
        Node current = head;
        for (int i = 1; i <= index; i++) {
            current = current.linkToNext;
        }
        return current.value;
    }

    public Object set(Object value, int index) {
        validateIndex(index);
        Node current = head;
        for (int i = 1; i <= index; i++) {
            current = current.linkToNext;
        }
        Object beforeUpdating = current.value;
        current.value = value;
        return beforeUpdating;
    }

    public void clear() {
        if (head != null) {
            Node current = head;
            while (current.linkToNext != null) {
                current.value = null;
                head = current.linkToNext;
                head.linkToPrevious = null;
                current.linkToNext = null;
                current = head;
            }
            head.value = null;
            head = null;
        }
        size = 0;
    }

    public int indexOf(Object value) {
        Node current = head;
        if (value == null) {
            for (int i = 0; i < size; i++) {
                if (current.value == null) {
                    return i;
                }
                current = current.linkToNext;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (value.equals(current.value)) {
                    return i;
                }
                current = current.linkToNext;
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
                current = current.linkToPrevious;
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (value.equals(current.value)) {
                    return i;
                }
                current = current.linkToPrevious;
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
            current = current.linkToNext;
        }
        return stringJoiner.toString();
    }


    private void validateIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is " + index + ". For adding the index should be between 0 and " + size + "(inclusive).");
        }
    }

    private void validateIndex(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty, size is " + size);
        } else if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is " + index + ". It should be between 0 and " + size + "(exclusive).");
        }
    }

    private static class Node {
        Object value;
        Node linkToPrevious;
        Node linkToNext;

        public Node(Object value) {
            this.value = value;
        }
    }

    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {
        Node current = head;
        int i = 0;

        public boolean hasNext() {
            return i < size;

        }

        public Object next() {
            Object result = current.value;
            current = current.linkToNext;
            i++;
            return result;
        }
    }
}
