package com.stroganova.tasks.map;

public interface Map {
    Object put(Object key, Object value);

    Object get(Object key);

    Object remove(Object key);

    int size();

    boolean containsKey(Object value);
}

