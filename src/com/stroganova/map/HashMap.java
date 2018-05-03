package com.stroganova.map;

import java.util.ArrayList;
import java.util.Objects;
import java.util.*;
//import java.util.Map;

public class HashMap implements com.stroganova.map.Map {
    private static final int INITIAL_CAPACITY = 5;
    private ArrayList[] buckets;
    private int size;

    public HashMap() {
        this(INITIAL_CAPACITY);
    }

    public HashMap(int capacity) {
        buckets = new ArrayList[capacity];
    }

/*    @Override
    public Object put(Object key, Object value) {
        Object oldValue = null;

        ArrayList innerBucket = getInnerBucket(key);
        if (innerBucket == null) {
            innerBucket = new ArrayList();
        }
        Entry entry = getEntry(key);
        if (entry != null) {
            oldValue = entry.value;
            entry.value = value;
        } else {
            Entry newEntry = new Entry(key, value);
            innerBucket.add(newEntry);
            size++;
        }
        return oldValue;
    }*/

    @Override
    public Object put(Object key, Object value) {
        Object oldValue = null;
        int bucketIndex = getIndex(key);

        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new ArrayList();
        }

        ArrayList innerBucket = buckets[bucketIndex];
        Entry entry = getEntry(key);
        if (entry != null) {
            oldValue = entry.value;
            entry.value = value;
        } else {
            Entry newEntry = new Entry(key, value);
            innerBucket.add(newEntry);
            size++;
        }
        return oldValue;
    }


    @Override
    public Object putIfAbsent(Object key, Object value) {
        return null;
    }

    @Override
    public void putAll(com.stroganova.map.Map map) {

    }

    @Override
    public void putAllIfAbsent(com.stroganova.map.Map map) {

    }

    @Override
    public Object get(Object key) {
        Entry current = getEntry(key);
        return current.value;
    }

    @Override
    public Object remove(Object key) {
        Entry removedEntry = getEntry(key);
        ArrayList innerBucket = getInnerBucket(key);
        innerBucket.remove(removedEntry);
        size--;
        return removedEntry.value;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(Object key) {
        return getEntry(key) != null;
    }

    private int getIndex(Object key) {


        return key == null ? 0 : key.hashCode() % buckets.length;
    }

    private Entry getEntry(Object key) {
        ArrayList innerBucket = getInnerBucket(key);
        if (innerBucket != null) {
            for (Object obj : innerBucket) {
                Entry entry = (Entry) obj;
                if (Objects.equals(key, entry.key)) {
                    return entry;
                }
            }
        }
        return null;
    }

    private ArrayList getInnerBucket(Object key) {
        return buckets[getIndex(key)];
    }

    @Override
    public Iterator iterator() {
        return null;
    }


    private static class Entry {
        private Object key;
        private Object value;

        Entry(Object newKey, Object newValue) {
            key = newKey;
            value = newValue;
        }

        public String toString() {
            return "[" + key + ", " + value + "] ";
        }
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {

            buckets[i] = null;

        }
        size = 0;
    }
}