package com.stroganova;

import com.stroganova.list.LinkedList;
import com.stroganova.list.List;

/**
 * Created by YONA on 07.05.2018.
 */
public class Test {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("str1");
        list.add("str2");
        list.add("str3");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
