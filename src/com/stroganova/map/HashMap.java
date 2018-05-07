package com.stroganova.map;

import java.util.*;
import java.util.Objects;

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
        int bucketIndex = getIndex(key);
        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new ArrayList();
        }
        ArrayList innerBucket = buckets[bucketIndex];
        Entry entry = (Entry) getEntry(key);
        Object oldValue = null;
        if (entry != null) {
            oldValue = entry.value;
            entry.value = value;
        } else {
            Entry newEntry = new Entry(key, value);
            innerBucket.add(newEntry);
            size++;
        }
        if (size > buckets.length * LOAD_FACTOR) {
            grow();
        }
        return oldValue;
    }

    @Override
    public Object putIfAbsent(Object key, Object value) {
        return get(key) != null ? get(key) : put(key, value);
    }

    @Override
    public void putAll(Map map) {
        Iterator mapIterator = map.iterator();
        while (mapIterator.hasNext()) {
            Entry entry = (Entry) mapIterator.next();
            put(entry.key, entry.value);
        }
    }

    @Override
    public void putAllIfAbsent(Map map) {
        Iterator mapIterator = map.iterator();
        while (mapIterator.hasNext()) {
            Entry entry = (Entry) mapIterator.next();
            putIfAbsent(entry.key, entry.value);
        }
    }

    @Override
    public Object get(Object key) {
        Entry current = (Entry) getEntry(key);
        return current != null ? current.value : null;
    }

    @Override
    public Object remove(Object key) {
        if (containsKey(key)) {
            Entry removedEntry = (Entry) getEntry(key);
            int index = getIndex(key);
            ArrayList innerBucket = buckets[index];
            innerBucket.remove(removedEntry);
            size--;
            return removedEntry.value;
        }
        return null;
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
        int index = 0;
        if (key != null) {
            index = Math.abs(key.hashCode()) % buckets.length;
            if (index < 0) {
                index = -index;
            }
        }
        return index;
    }

    private void grow() {
        buckets = Arrays.copyOf(buckets, (int) (buckets.length * 2));
        for (int i = 0; i < buckets.length; i++) {
            ArrayList bucket = buckets[i];
            if (bucket != null) {
                for (int j = 0; j < bucket.size(); j++) {
                    Entry entry = (Entry) bucket.get(j);
                    if (i != getIndex(entry.key)) {
                        bucket.remove(j);
                        size--;
                        put(entry.key, entry.value);
                    }
                }
                if (bucket.size() == 0) {
                    buckets[i] = null;
                }
            }
        }
    }

    private Object getEntry(Object key) {
        int index = getIndex(key);
        ArrayList innerBucket = buckets[index];
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

    private static class Entry {
        private Object key;
        private Object value;

        Entry(Object newKey, Object newValue) {
            key = newKey;
            value = newValue;
        }

        public String toString() {
            return key + ":" + value;
        }
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
        size = 0;
    }

    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {
        int i = 0;
        int count = size;
        int currentIndex;
        Iterator bucket = getBucket(i).iterator();

        public boolean hasNext() {
            return count != 0;
        }

        public Object next() {
            if (!bucket.hasNext()) {
                currentIndex++;
                bucket = getBucket(currentIndex).iterator();
            }
            count--;
            return bucket.next();
        }

        private ArrayList getBucket(int i) {
            while (buckets[i] == null) {
                i++;
            }
            currentIndex = i;
            return buckets[i];
        }
    }
}