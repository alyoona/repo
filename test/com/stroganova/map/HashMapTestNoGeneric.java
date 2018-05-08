package com.stroganova.map;

public class HashMapTestNoGeneric extends AbstarctMapTestNoGeneric{
    @Override
    public MapNoGeneric getMap() {
        return new HashMapNoGeneric();
    }
}
