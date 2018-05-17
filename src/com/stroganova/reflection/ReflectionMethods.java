package com.stroganova.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Objects;
import java.util.StringJoiner;


//        Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
//        Метод принимает объект и меняет всего его привантые поля на их нулевые значение (null, 0, false etc)

public class ReflectionMethods {
    //Метод принимает класс и возвращает созданный объект этого класса
    static Object getInstanceOfClass(Class tclass) throws IllegalAccessException, InstantiationException {
        return tclass.newInstance();
    }

    //Метод принимает object и вызывает у него все методы без параметров
    static void callMethodsWithoutParameters(Object obj) throws Exception {
        Class clazz = obj.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (0 == method.getParameterCount()) {
                method.setAccessible(true);
                method.invoke(obj, new Object[0]);
                method.setAccessible(false);
            }
        }
    }

    //Метод принимает object и выводит на экран все сигнатуры методов в который есть final

    static void printMethodSignaturesWithFinal(Object obj) {
        Class clazz = obj.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
           if(Modifier.isFinal(method.getModifiers())) {

               StringBuilder builder = new StringBuilder();
               builder.append(method.getName());
               builder.append("(");

               if (method.getParameterCount() != 0) {
                   Class[] params = method.getParameterTypes();
                   for (Class cl : params) {
                       builder.append(cl.getName());
                       builder.append(" ");
                       builder.append(cl.getName().toLowerCase());
                       builder.append(", ");
                   }
                   builder.toString();
                   int length = builder.toString().length();
                   builder.replace(length - 2, length - 1, ")");

                   System.out.println(builder.toString());
               }
               else

           }
        }
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
