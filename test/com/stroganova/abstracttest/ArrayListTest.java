package com.stroganova.abstracttest;

import com.stroganova.list.*;

public class ArrayListTest extends AbstractListTest {
    @Override
    public List<String> getList() {
        return new ArrayList<>();
    }
}
