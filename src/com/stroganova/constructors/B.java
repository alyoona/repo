package com.stroganova.constructors;

class B extends A {

    public B (int i){
        super(i);
//        super(); or without super(); --error
        System.out.println("B");
        System.out.println(i);
    }
}
