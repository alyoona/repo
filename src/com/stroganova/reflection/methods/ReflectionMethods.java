package com.stroganova.reflection.methods;

import java.lang.reflect.*;

public class ReflectionMethods {
    //#1.Метод принимает класс и возвращает созданный объект этого класса
    static Object getInstanceOfClass(Class clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

    //#2.Метод принимает object и вызывает у него все методы без параметров
    static void invokeMethodsWithoutParameters(Object obj) throws IllegalAccessException, InvocationTargetException {
        Class clazz = obj.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (0 == method.getParameterCount()) {
                method.setAccessible(true);
                method.invoke(obj);
                method.setAccessible(false);
            }
        }
    }

    //#3.Метод принимает object и выводит на экран все сигнатуры методов в который есть final
    static void printFinalMethods(Object obj) {
        Class clazz = obj.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (Modifier.isFinal(method.getModifiers())) {
                System.out.println(method);
            }
        }
    }

    //#4.Метод принимает Class и выводит все не публичные методы этого класса
    static void printUnPublicMethods(Class clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (!Modifier.isPublic(method.getModifiers())) {
                System.out.println(method);
            }
        }
    }

    //#5.Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
    public static void printParentsAndInterfaces(Class clazz) {
        Class parent = clazz.getSuperclass();
        while (parent != null) {
            System.out.println(parent);
            parent = parent.getSuperclass();
        }
        if (clazz.getInterfaces() != null) {
            for (Class interfase : clazz.getInterfaces()) {
                System.out.println(interfase);
            }
        }
    }

    //#6.Метод принимает объект и меняет всего его привантые поля на их нулевые значение (null, 0, false etc)
    static void setDefaultsValues(Object obj) throws IllegalAccessException {
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                Class type = field.getType();
                field.setAccessible(true);
                if (type.isPrimitive()) {
                    if (type.getName() == "boolean") {
                        field.set(obj, false);
                    } else if (type.getName() == "byte") {
                        field.set(obj, (byte) 0);
                    } else if (type.getName() == "short") {
                        field.set(obj, (short) 0);
                    } else if (type.getName() == "char") {
                        field.set(obj, (char) 0);
                    } else {
                        field.set(obj, 0);
                    }
                } else {
                    field.set(obj, null);
                }
                field.setAccessible(false);
            }
        }
    }

    //#7.Принимает объект и вызывает методы проанотированные аннотацией @Run (аннотация Ваша, написать самим)
    static void invokeMethodsAtRun(Object obj) throws InvocationTargetException, IllegalAccessException {
        Class clazz = obj.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Run.class)) {
                method.invoke(obj);
            }
        }
    }

    // #8.Принимает объект.
    // Поля проаннотиваные аннотацией @Inject заполняет объектом того класса который находиться в поле аннотации Class clazz().
    // Если поле аннотации пустое. Создает пустой экзепляр класса, базируясь на типе поля (аннотация Ваша, написать самим)
    static void initializeFieldsAtInject(Object obj) throws IllegalAccessException, InstantiationException {
        Class clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Inject injectAnnotation = field.getAnnotation(Inject.class);
                Object value = (injectAnnotation.clazz() == Void.class ?
                        field.getType().newInstance() :
                        injectAnnotation.clazz().newInstance());
                field.set(obj, value);
                field.setAccessible(false);
            }
        }
    }
}


