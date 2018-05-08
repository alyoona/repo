package com.stroganova.abstracttest;

import com.stroganova.list.*;

public class LinkedListTest extends AbstractListTest {
   @Override
    public List<String> getList() {
        return new LinkedList<>();
    }
}

