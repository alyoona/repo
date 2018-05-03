package com.stroganova.generics;

import java.util.ArrayList;
import java.util.List;

public class LearnGenerics {
    public static void main(String[] args) {
        List rawlist = new ArrayList();
        List<String> list = new ArrayList<String>();

        rawlist = list;

        rawlist.add(8);


        String s = list.get(0);

    }
}
