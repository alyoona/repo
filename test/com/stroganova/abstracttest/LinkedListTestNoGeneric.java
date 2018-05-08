package com.stroganova.abstracttest;

import com.stroganova.list.*;

public class LinkedListTestNoGeneric extends AbstractListTestNoGeneric {
    @Override
    public ListNoGeneric getList() {
        return new LinkedListNoGeneric();
    }
}
