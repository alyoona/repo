package com.stroganova.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Demo {
    public static void main(String[] args) {
        C c = new C();
        c.methodWritedInClass();//??
        List newList = new ArrayList();
        System.out.println(newList.add(1));
        //нарерно метод должен возвращать этот объект
        newList = c.SecondAddByAnOverriddenMethod();
        System.out.println(newList.add(1));//теперь выводит пятерку
        int p = (int) Math.pow(-2,31);
        System.out.println(p);//-2147483648
        int i = Math.abs(p);
        System.out.println(i); //-2147483648
        long k = (long) i * (-1);
        System.out.println(k);//2147483648




    }
}
