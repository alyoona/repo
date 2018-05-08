package com.stroganova.map;

import java.util.*;
import java.util.Objects;

public class HashMap<K,V> implements Map<K,V> {
    private static final int INITIAL_CAPACITY = 5;
    private static final double LOAD_FACTOR = 0.75;
    private ArrayList<Entry<K,V>>[] buckets;
    private int size;

    public HashMap() {
        this(INITIAL_CAPACITY);
    }

    public HashMap(int capacity) {
        buckets = (ArrayList<Entry<K,V>>[]) new ArrayList[capacity];
    }

    @Override
    public V put(K key, V value) {
        int bucketIndex = getIndex(key);
        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new ArrayList<>();
        }
        ArrayList<Entry<K,V>> innerBucket = buckets[bucketIndex];
        Entry<K,V> entry = getEntry(key);
        V oldValue = null;
        if (entry != null) {
            oldValue = entry.value;
            entry.value = value;
        } else {
            Entry<K,V> newEntry = new Entry<>(key, value);
            innerBucket.add(newEntry);
            size++;
        }
        if (size > buckets.length * LOAD_FACTOR) {
            grow();
        }
        return oldValue;
    }

    @Override
    public V putIfAbsent(K key, V value) {
        return get(key) != null ? get(key) : put(key, value);
    }

    @Override
    public void putAll(Map<K,V> map) {
        Iterator<Entry<K,V>> mapIterator = map.iterator();
        while (mapIterator.hasNext()) {
            Entry<K,V> entry = mapIterator.next();
            put(entry.key, entry.value);
        }
    }

    @Override
    public void putAllIfAbsent(Map<K,V> map) {
        Iterator<Entry<K,V>> mapIterator = map.iterator();
        while (mapIterator.hasNext()) {
            Entry<K,V> entry = mapIterator.next();
            putIfAbsent(entry.key, entry.value);
        }
    }

    @Override
    public V get(K key) {
        Entry<K,V> current = getEntry(key);
        return current != null ? current.value : null;
    }

    @Override
    public V remove(K key) {
        if (containsKey(key)) {
            Entry <K,V> removedEntry = getEntry(key);
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
    public boolean containsKey(K key) {
        return getEntry(key) != null;
    }

    private int getIndex(K key) {
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
            ArrayList<Entry<K,V>> bucket = buckets[i];
            if (bucket != null) {
                for (int j = 0; j < bucket.size(); j++) {
                    Entry<K,V> entry = bucket.get(j);
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

    private Entry<K,V> getEntry(K key) {
        int index = getIndex(key);
        ArrayList<Entry<K,V>> innerBucket = buckets[index];
        if (innerBucket != null) {
            for (Entry<K,V> obj : innerBucket) {
                Entry<K,V> entry = obj;
                if (Objects.equals(key, entry.key)) {
                    return entry;
                }
            }
        }
        return null;
    }

    public static class Entry<K,V> {
        private K key;
        private V value;

        Entry(K newKey, V newValue) {
            key = newKey;
            value = newValue;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
        size = 0;
    }

    public Iterator<Entry<K,V>> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Entry<K,V>> {
        int i = 0;
        int count = size;
        int currentIndex;
        Iterator<Entry<K,V>> bucket = getBucket(i).iterator();

        public boolean hasNext() {
            return count != 0;
        }

        public Entry<K,V> next() {
            if (!bucket.hasNext()) {
                currentIndex++;
                bucket = getBucket(currentIndex).iterator();
            }
            count--;
            return bucket.next();
        }

        private ArrayList<Entry<K,V>> getBucket(int i) {
            while (buckets[i] == null) {
                i++;
            }
            currentIndex = i;
            return buckets[i];
        }
    }
}