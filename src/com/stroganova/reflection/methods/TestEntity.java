package com.stroganova.reflection.methods;

public class TestEntity {

    @Inject
    D d;
    @Inject(clazz = E.class)
    D e;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TestEntity{");
        sb.append("d=").append(d);
        sb.append(", e=").append(e);
        sb.append('}');
        return sb.toString();
    }
}
