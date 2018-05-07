package com.stroganova.demo;

import java.util.ArrayList;
import java.util.List;

public class C {
    public void methodWritedInClass() {
        int count = 5; // effectively final

        List list = new ArrayList() {
            public boolean add(Object value) {
                System.out.println(count);
                return super.add(value);
            }
        };
    }

    public List SecondAddByAnOverriddenMethod() {
        int count = 5; // effectively final
        List list = new ArrayList() {
            public boolean add(Object value) {
                System.out.println(count);
                return super.add(value);
            }
        };
        return list;
    }
}
