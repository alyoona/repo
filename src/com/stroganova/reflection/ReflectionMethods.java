package com.stroganova.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


//        Метод принимает object и вызывает у него все методы без параметров
//        Метод принимает object и выводит на экран все сигнатуры методов в который есть final

//        Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
//        Метод принимает объект и меняет всего его привантые поля на их нулевые значение (null, 0, false etc)

public class ReflectionMethods {
    //Метод принимает класс и возвращает созданный объект этого класса
    static <T> Object getInstanceOfClass(Class<T> tclass) throws IllegalAccessException, InstantiationException {
        return tclass.newInstance();
    }

    static void callMethodsWithoutParameters(Object obj) {

    }


    //Метод принимает Class и выводит все не публичные методы этого класса
    static void ptintUnpublicMethos(Class clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (!Modifier.isPublic(method.getModifiers())) {
                System.out.println(method);
            }
        }
    }


}
