package com.stroganova.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TypeErasure {

    static void print(Collection<Object> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        SomeType<?> someType = new SomeType<Object>();
        List<String> list = Arrays.asList("value");
        someType.test(list);

        List<String> stringList = new ArrayList<String>();



    }
}
