package com.stroganova.map;

public interface MapNoGeneric extends Iterable {
    Object put(Object key, Object value);

    Object putIfAbsent(Object key, Object value);

    void putAll(MapNoGeneric map);

    void putAllIfAbsent(MapNoGeneric map);

    Object get(Object key);

    Object remove(Object key);

    int size();

    boolean containsKey(Object value);
    void clear();

}