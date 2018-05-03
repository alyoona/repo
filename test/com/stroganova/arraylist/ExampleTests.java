package com.stroganova.arraylist;

import org.junit.Before;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;


public class ExampleTests {
    ArrayList list;

    @Before
    public void before() {
        list = new ArrayList();
        list.add("str1");
        list.add("str2");
        list.add("str3");
    }


    @org.junit.Test
    public void testAddIntoEmptyList() {
        list.clear();
        assertEquals(list.size(), 0);

        list.add("one");
        assertEquals(list.get(0), "one");
        assertEquals(list.size(), 1);
    }

    @org.junit.Test
    public void testAddIntoNotEmptyList() {
        list.add("str4");
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "str2");
        assertEquals(list.get(2), "str3");
        assertEquals(list.get(3), "str4");
        assertEquals(list.size(), 4);
    }

    @org.junit.Test
    public void testAddEnsureCapacity() {
        list.add("str4");
        list.add("str5");
        list.add("str6");
        assertEquals(list.get(5), "str6");
        assertEquals(list.size(), 6);
    }

    @org.junit.Test
    public void testAddIndexEmptyList() {
        list.clear();
        assertEquals(list.size(), 0);
        list.add("begin", 0);
        assertEquals(list.get(0), "begin");
        assertEquals(list.size(), 1);
    }

    @org.junit.Test
    public void testAddIndexBegin() {
        list.add("begin", 0);
        assertEquals(list.get(0), "begin");
        assertEquals(list.get(1), "str1");
        assertEquals(list.get(2), "str2");
        assertEquals(list.get(3), "str3");
        assertEquals(list.size(), 4);
    }

    @org.junit.Test
    public void testAddIndexCenter() {
        list.add("center", 1);
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "center");
        assertEquals(list.get(2), "str2");
        assertEquals(list.get(3), "str3");
        assertEquals(list.size(), 4);
    }

    @org.junit.Test
    public void testAddIndexEnd() {
        list.add("end", 3);
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "str2");
        assertEquals(list.get(2), "str3");
        assertEquals(list.get(3), "end");
        assertEquals(list.size(), 4);
    }

    @org.junit.Test
    public void testIndexOf() {
        int actual = list.indexOf("str2");
        assertEquals(actual, 1);
    }

    @org.junit.Test
    public void testIndexOfDoesNotExist() {
        int actual = list.indexOf("str50");
        assertEquals(actual, -1);
    }

    @org.junit.Test
    public void testLastIndexOf() {
        list.add("str2", 2);
        int actual = list.lastIndexOf("str2");
        assertEquals(actual, 2);
    }

    @org.junit.Test
    public void testLastIndexOfDoesNotExist() {
        int actual = list.lastIndexOf("str50");
        assertEquals(actual, -1);
    }

    @org.junit.Test
    public void testContainsTrue() {
        assertTrue(list.contains("str3"));
    }


    @org.junit.Test
    public void testContainsFalse() {
        assertFalse(list.contains("str50"));
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testSetEmptyList() {
        list.clear();
        assertEquals(list.size(), 0);
        list.set("setValue", 0);
        assertEquals(list.get(0), "setValue");
        assertEquals(list.size(), 1);
    }

    @org.junit.Test
    public void testSetBegin() {
        list.set("setValue", 0);
        assertEquals(list.get(0), "setValue");
        assertEquals(list.get(1), "str2");
        assertEquals(list.get(2), "str3");
        assertEquals(list.size(), 3);
    }

    @org.junit.Test
    public void testSetCenter() {
        list.set("setValue", 1);
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "setValue");
        assertEquals(list.get(2), "str3");
        assertEquals(list.size(), 3);
    }

    @org.junit.Test
    public void testSetEnd() {
        list.set("setValue", 2);
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "str2");
        assertEquals(list.get(2), "setValue");
        assertEquals(list.size(), 3);
    }

    @org.junit.Test
    public void testClear() {
        list.clear();
        assertEquals(list.size(), 0);
    }

    @org.junit.Test
    public void testGetBegin() {
        Object actual = list.get(0);
        assertEquals(actual, "str1");
    }

    @org.junit.Test
    public void testGetCenter() {
        Object actual = list.get(1);
        assertEquals(actual, "str2");
    }

    @org.junit.Test
    public void testGetEnd() {
        Object actual = list.get(2);
        assertEquals(actual, "str3");
    }

    @org.junit.Test
    public void testRemoveBegin() {
        list.remove(0);
        assertEquals(list.get(0), "str2");
        assertEquals(list.get(1), "str3");
        assertEquals(list.size(), 2);
    }

    @org.junit.Test
    public void testRemoveCenter() {
        list.remove(1);
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "str3");
        assertEquals(list.size(), 2);
    }

    @org.junit.Test
    public void testRemoveEnd() {
        list.remove(2);
        assertEquals(list.get(0), "str1");
        assertEquals(list.get(1), "str2");
        assertEquals(list.size(), 2);
    }
}