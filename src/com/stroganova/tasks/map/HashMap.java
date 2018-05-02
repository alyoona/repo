package com.stroganova.tasks.map;
import java.util.ArrayList;

public class HashMap implements Map {
    private ArrayList[] buckets;
    private int size;

    @Override
    public Object put(Object key, Object value) {
        Entry entry = new Entry(key, value);



        return null;
    }

    @Override
    public Object get(Object key) {
        ArrayList bucket = buckets[getIndex(key)];

        return null;
    }

    private int getIndex(Object key) {
        return key.hashCode() % 5;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean containsKey(Object value) {
        return false;
    }

    private static class Entry {
        Object key;
        Object value;

        Entry(Object newKey, Object newValue){
            key = newKey;
            value = newValue;
        }
    }

}