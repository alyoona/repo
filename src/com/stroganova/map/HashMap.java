package com.stroganova.map;

import java.util.ArrayList;
import java.util.Objects;
import java.util.*;
import java.util.ArrayList;

public class HashMap implements Map {
    private static final int INITIAL_CAPACITY = 5;
    private static final double LOAD_FACTOR = 0.75;


    private ArrayList[] buckets;
    private int size;

    public HashMap() {
        this(INITIAL_CAPACITY);
    }

    public HashMap(int capacity) {
        buckets = new ArrayList[capacity];
    }


    @Override
    public Object put(Object key, Object value) {
        if (size > buckets.length * LOAD_FACTOR) {
            grow();
        }
        int bucketIndex = getIndex(key);
        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new ArrayList();
        }
        ArrayList innerBucket = buckets[bucketIndex];
        Entry entry = getEntry(key);
        Object oldValue = null;
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
        return get(key) != null ? get(key) : put(key, value);
    }

    @Override
    public void putAll(Map map) {
        ArrayList mapKeys = map.keys();
        for (Object mapKey : mapKeys) {
            Object valueMap = map.get(mapKey);
            put(mapKey, valueMap);
        }
    }

    @Override
    public void putAllIfAbsent(Map map) {
        ArrayList mapKeys = map.keys();
        for (Object mapKey : mapKeys) {
            Object valueMap = map.get(mapKey);
            putIfAbsent(mapKey, valueMap);
        }
    }

    @Override
    public Object get(Object key) {
        Entry current = getEntry(key);
        return current != null ? current.value : null;
    }

    @Override
    public Object remove(Object key) {
        Entry removedEntry = getEntry(key);
        ArrayList innerBucket = getInnerBucket(key);
        if (innerBucket != null) {
            innerBucket.remove(removedEntry);
            size--;
        }
        return removedEntry != null ? removedEntry.value : null;
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

    private void grow(int length) {
        buckets = Arrays.copyOf(buckets, length * 2);
    }

    private void grow() {
        grow(buckets.length);
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

    public ArrayList keys() {
        ArrayList keys = new ArrayList();
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                ArrayList innerBucket = buckets[i];
                for (Object obj : innerBucket) {
                    Entry entry = (Entry) obj;
                    keys.add(entry.key);
                }
            }
        }
        return keys;
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
            buckets[i].clear();
            buckets[i] = null;
        }
        size = 0;
    }

    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {
        int i;
        int j;
        int count = size;

        public boolean hasNext() {
            return size != 0;
        }

        public Object next() {
            ArrayList innerBucket = buckets[i];
            Entry result = (Entry) innerBucket.get(j);

            if (++j < innerBucket.size()) {
                result = (Entry) innerBucket.get(j);
            } else {
                i++;
                j = 0;
            }

            return result;
        }

    }
}