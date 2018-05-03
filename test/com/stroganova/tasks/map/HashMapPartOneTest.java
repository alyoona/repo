package com.stroganova.tasks.map;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class HashMapPartOneTest {

    HashMapPartOne map;

    @Before
    public void before() {
        map = new HashMapPartOne();
        map.put(0, "value1");
        map.put(1, "value2");
        map.put(2, "value3");
        map.put(3, "value4");
        map.put(4, "value5");
    }

    @Test
    public void testPutZero() {
        map.clear();
        assertEquals(0, map.size());
        assertEquals(null, map.put(5, "value1"));
        assertEquals("value1", map.get(5));
        assertEquals(0, map.bucket(5));
        assertEquals(1, map.size());

        assertEquals(null, map.put(10, "value10"));
        assertEquals("value10", map.get(10));
        assertEquals(0, map.bucket(10));
        assertEquals(2, map.size());
    }

    @Test
    public void testPutOne() {
        map.clear();
        assertEquals(0, map.size());
        assertEquals(null, map.put(6, "value2"));
        assertEquals("value2", map.get(6));
        assertEquals(1, map.size());
        assertEquals(1, map.bucket(6));
    }

    @Test
    public void testPutTwo() {
        map.clear();
        assertEquals(0, map.size());
        assertEquals(null, map.put(7, "value3"));
        assertEquals("value3", map.get(7));
        assertEquals(1, map.size());
        assertEquals(2, map.bucket(7));
    }

    @Test
    public void testPutThree() {
        map.clear();
        assertEquals(0, map.size());
        assertEquals(null, map.put(8, "value4"));
        assertEquals("value4", map.get(8));
        assertEquals(1, map.size());
        assertEquals(3, map.bucket(8));
    }

    @Test
    public void testPutFour() {
        map.clear();
        assertEquals(0, map.size());
        assertEquals(null, map.put(9, "value5"));
        assertEquals("value5", map.get(9));
        assertEquals(1, map.size());
        assertEquals(4, map.bucket(9));
    }

    @Test
    public void testPutUpdatingZero() {
        assertEquals(5, map.size());
        assertEquals(0, map.bucket(0));
        assertEquals("value1", map.get(0));
        assertEquals("value1", map.put(0, "newValue1"));
        assertEquals("newValue1", map.get(0));
        assertEquals(0, map.bucket(0));
        assertEquals(5, map.size());

        assertEquals(null, map.put(10, "value10"));
        assertEquals("value10", map.get(10));
        assertEquals(0, map.bucket(10));
        assertEquals(6, map.size());
    }

    @Test
    public void testPutUpdatingOne() {
        assertEquals(5, map.size());
        assertEquals(1, map.bucket(1));
        assertEquals("value2", map.get(1));
        assertEquals("value2", map.put(1, "newValue2"));
        assertEquals("newValue2", map.get(1));
        assertEquals(1, map.bucket(1));
        assertEquals(5, map.size());
    }

    @Test
    public void testPutUpdatingTwo() {
        assertEquals(5, map.size());
        assertEquals(2, map.bucket(2));
        assertEquals("value3", map.get(2));
        assertEquals("value3", map.put(2, "newValue3"));
        assertEquals("newValue3", map.get(2));
        assertEquals(2, map.bucket(2));
        assertEquals(5, map.size());
    }

    @Test
    public void testPutUpdatingThree() {
        assertEquals(5, map.size());
        assertEquals(3, map.bucket(3));
        assertEquals("value4", map.get(3));
        assertEquals("value4", map.put(3, "newValue4"));
        assertEquals("newValue4", map.get(3));
        assertEquals(3, map.bucket(3));
        assertEquals(5, map.size());
    }

    @Test
    public void testPutUpdatingFour() {
        assertEquals(5, map.size());
        assertEquals(4, map.bucket(4));
        assertEquals("value5", map.get(4));
        assertEquals("value5", map.put(4, "newValue5"));
        assertEquals("newValue5", map.get(4));
        assertEquals(4, map.bucket(4));
        assertEquals(5, map.size());
    }

    @Test
    public void testNull() {
        map.clear();
        assertEquals(0, map.size());
        assertEquals(null, map.put(null, "value"));
        assertEquals(0, map.bucket(null));
        assertEquals("value", map.get(null));
        assertEquals(1, map.size());

        assertEquals("value", map.put(null, null));
        assertEquals(null, map.get(null));
        assertEquals(0, map.bucket(null));
        assertEquals(1, map.size());

        assertEquals(true, map.containsKey(null));
        assertEquals(null, map.remove(null));
        assertEquals(0, map.size());
    }

    @Test
    public void testGet() {
        assertEquals("value1", map.get(0));
        assertEquals("value2", map.get(1));
        assertEquals("value3", map.get(2));
        assertEquals("value4", map.get(3));
        assertEquals("value5", map.get(4));
        map.put(15, "value1");
        map.put(16, "value2");
        map.put(17, "value3");
        map.put(18, "value4");
        map.put(19, "value5");
        assertEquals("value1", map.get(15));
        assertEquals("value2", map.get(16));
        assertEquals("value3", map.get(17));
        assertEquals("value4", map.get(18));
        assertEquals("value5", map.get(19));
        assertEquals(0, map.bucket(15));
        assertEquals(1, map.bucket(16));
        assertEquals(2, map.bucket(17));
        assertEquals(3, map.bucket(18));
        assertEquals(4, map.bucket(19));
    }

    @Test
    public void testRemove() {
        assertEquals(5, map.size());
        assertEquals(0, map.bucket(0));
        assertEquals("value1", map.remove(0));
        assertEquals(-1, map.bucket(0));

        assertEquals(4, map.size());
        assertEquals(1, map.bucket(1));
        assertEquals("value2", map.remove(1));
        assertEquals(-1, map.bucket(1));

        assertEquals(3, map.size());
        assertEquals(2, map.bucket(2));
        assertEquals("value3", map.remove(2));
        assertEquals(-1, map.bucket(2));

        assertEquals(2, map.size());
        assertEquals(3, map.bucket(3));
        assertEquals("value4", map.remove(3));
        assertEquals(-1, map.bucket(3));

        assertEquals(1, map.size());
        assertEquals(4, map.bucket(4));
        assertEquals("value5", map.remove(4));
        assertEquals(-1, map.bucket(4));
        assertEquals(0, map.size());
    }

    @Test
    public void testContains() {
        assertEquals(true, map.containsKey(0));
        map.remove(0);
        assertEquals(false, map.containsKey(0));

        assertEquals(true, map.containsKey(1));
        map.remove(1);
        assertEquals(false, map.containsKey(1));

        assertEquals(true, map.containsKey(2));
        map.remove(2);
        assertEquals(false, map.containsKey(2));

        assertEquals(true, map.containsKey(3));
        map.remove(3);
        assertEquals(false, map.containsKey(3));

        assertEquals(true, map.containsKey(4));
        map.remove(4);
        assertEquals(false, map.containsKey(4));
    }

    @Test(expected = NullPointerException.class)
    public void testGetMissingKey() {
        map.get(1212);
    }

    @Test(expected = NullPointerException.class)
    public void testGetEmptyMap() {
        map.clear();
        map.get(0);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveMissingKey() {
        map.get(1212);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveEmptyMap() {
        map.clear();
        map.get(0);
    }

}
