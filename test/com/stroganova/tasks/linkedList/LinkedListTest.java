package com.stroganova.tasks.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {
    private Object expected;
    private Object actual;
    private LinkedList list;

    @Test
    public void testAdd() {
        list = new LinkedList();
        for (int i = 0; i < 2; i++) {
            list.add(i);
        }
        actual = list.toString();
        expected = "[" + 0 + "," + 1 + "]";
        assertEquals(expected, actual);
    }

    @Test
    public void testAddByIndex() {

    }

}
