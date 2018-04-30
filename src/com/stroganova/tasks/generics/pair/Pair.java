package com.stroganova.tasks.generics.pair;

/**
 * Created by YONA on 28.04.2018.
 */
public class Pair<T> {
    public Pair() {
        first = null;
        second = null;
    }
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }


    public T getFirst() {
        return first;
    }

    public void setFirst(T newValue) {
        this.first = newValue;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T newValue) {
        this.second = newValue;
    }

    private T first;
    private T second;
}
