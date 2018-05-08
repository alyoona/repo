package com.stroganova.abstracttest;

import com.stroganova.list.*;

public class ArrayListTestNoGeneric extends AbstractListTestNoGeneric {
    @Override
    public ListNoGeneric getList() {
        return new ArrayListNoGenetic();
    }
}
