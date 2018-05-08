package com.stroganova;

import com.stroganova.list.ArrayList;
import com.stroganova.list.LinkedList;
import com.stroganova.list.List;
import com.stroganova.map.HashMap;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(0, "Value0");
        map.put(1, "Value1");
        map.put(2, "Value2");
        for (HashMap.Entry<Integer,String> entry : map) {//
            // entry.getKey()
            System.out.println("key = " + entry.getKey() +", value = " + entry.getValue());
        }
    }
}
