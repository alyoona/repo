package com.stroganova.map;

import java.util.*;

public class HashMapPartOne  {
     static final int INITIAL_CAPACITY = 5;
    private ArrayList[] buckets;
    private int size;

    public HashMapPartOne() {
        this(INITIAL_CAPACITY);
    }

    public HashMapPartOne(int capacity) {
        buckets = new ArrayList[capacity];
    }

    public Object put(Object key, Object value) {
        Object beforePut = null;
        Entry newEntry = new Entry(key, value);
        int i = getIndex(key);
        ArrayList innerBucket;
        if (buckets[i] == null) {
            innerBucket = new ArrayList();
            buckets[i] = innerBucket;
        } else {
            innerBucket = buckets[i];
        }
        int j = getInnerIndex(key);
        if (j != -1) {
            Entry currentEntry = (Entry) innerBucket.get(j);
            beforePut = currentEntry.value;
            innerBucket.set(j, newEntry);
        } else {
            innerBucket.add(newEntry);
            size++;
        }
        return beforePut;
    }


    public Object get(Object key) {
        validate(key);
        Entry current = (Entry) buckets[getIndex(key)].get(getInnerIndex(key));
        return current.value;
    }

    public Object remove(Object key) {
        validate(key);
        Entry removed = (Entry) buckets[getIndex(key)].get(getInnerIndex(key));
        buckets[getIndex(key)].remove(getInnerIndex(key));
        size--;
        return removed.value;
    }


    public int size() {
        return size;
    }

    public boolean containsKey(Object key) {
        return getInnerIndex(key) != -1;
    }

    private int getIndex(Object key) {
        return key == null ? 0 : key.hashCode() % buckets.length;
    }

    private int getInnerIndex(Object key) {
        ArrayList innerBucket = buckets[getIndex(key)];
        if (innerBucket != null) {
            for (int i = 0; i < innerBucket.size(); i++) {
                if (Objects.equals(key, ((Entry) innerBucket.get(i)).key)) {
                    return i;
                }
            }
        }
        return -1;
    }


    private static class Entry {
        private Object key;
        private Object value;

        Entry(Object newKey, Object newValue) {
            key = newKey;
            value = newValue;
        }

        public String toString() {
            return "[" + String.valueOf(key) + ", " + String.valueOf(value) + "] ";
        }
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++)
            buckets[i] = null;
        size = 0;
    }

    private void validate(Object key) {
        if (size == 0) {
            throw new NullPointerException("Map is empty");
        } else if (getInnerIndex(key) == -1) {
            throw new NullPointerException("\"" + String.valueOf(key) + "\" key does not exist.");
        }
    }

    public int bucket(Object key) {
        return containsKey(key) ? getIndex(key) : -1;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                result += "bucket[" + i + "]: ";
                for (int j = 0; j < buckets[i].size(); j++) {
                    result += (buckets[i].get(j).toString());
                }
                result += "\n";
            } else {
                result += "";
            }
        }
        return result;
    }
}