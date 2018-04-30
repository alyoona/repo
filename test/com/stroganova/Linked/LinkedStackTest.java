package com.stroganova.Linked;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LinkedStackTest {

    @Test
    public void testPush() {
        String expected = "[A, B, C]";
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push("A");
        linkedStack.push("B");
        linkedStack.push("C");
        String actual = linkedStack.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testPop() {
        String expected = "[C, B, A]";
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push("A");
        linkedStack.push("B");
        linkedStack.push("C");
        String actual = "[";
        for (int i = 0; i < 3; i++) {
            actual += linkedStack.pop();
            if (i != 2) {
                actual += ", ";
            } else {
                actual += "]";
            }
        }
        assertEquals(expected, actual);
    }

}

