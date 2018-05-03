package com.stroganova.map;

public interface Map extends Iterable {
    Object put(Object key, Object value);

    Object putIfAbsent(Object key, Object value);

    void putAll(Map map);

    void putAllIfAbsent(Map map);

    Object get(Object key);

    Object remove(Object key);

    int size();

    boolean containsKey(Object value);
}



