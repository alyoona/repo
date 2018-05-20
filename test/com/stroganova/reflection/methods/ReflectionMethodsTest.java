package com.stroganova.reflection.methods;

import com.stroganova.reflection.methods.D;
import com.stroganova.reflection.methods.E;
import com.stroganova.reflection.methods.ReflectionMethods;
import com.stroganova.reflection.methods.TestEntity;
import org.junit.Test;
import java.io.*;
import java.lang.reflect.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReflectionMethodsTest {

    @Test
    public void testPrintUnPublicMethods() {
        System.out.println("START testPrintUnPublicMethods()");
        ReflectionMethods.printUnPublicMethods(E.class);
        System.out.println("END testPrintUnPublicMethods()");
        System.out.println();
    }

    @Test
    public void testPrintFinalMethods() {
        System.out.println("START testPrintFinalMethods()");
        E e = new E();
        ReflectionMethods.printFinalMethods(e);
        System.out.println("END testPrintFinalMethods()");
        System.out.println();
    }

    @Test
    public void testPrintParentsAndInterfaces() throws IOException {
        System.out.println("START testPrintParentsAndInterfaces()");
        ReflectionMethods.printParentsAndInterfaces(E.class);
        System.out.println("END testPrintParentsAndInterfaces()");
        System.out.println();
    }

    @Test
    public void testInvokeMethodsWithoutParameters() throws InvocationTargetException, IllegalAccessException {
        System.out.println("START testInvokeMethodsWithoutParameters()");
        E e = new E();
        ReflectionMethods.invokeMethodsWithoutParameters(e);
        System.out.println("END testInvokeMethodsWithoutParameters()");
        System.out.println();
    }

    @Test
    public void testInvokeMethodsAtRun() throws InvocationTargetException, IllegalAccessException {
        System.out.println("START testInvokeMethodsAtRun()");
        E e = new E();
        ReflectionMethods.invokeMethodsAtRun(e);
        System.out.println("END testInvokeMethodsAtRun()");
        System.out.println();
    }

    @Test
    public void testGetInstanceOfClass() throws InstantiationException, IllegalAccessException {
        Object o = ReflectionMethods.getInstanceOfClass(E.class);
        assertTrue(o instanceof E);
    }

    @Test
    public void testInitializeFieldsAtInject() throws InstantiationException, IllegalAccessException {
        TestEntity testEntity = new TestEntity();
        assertTrue(!(testEntity.d instanceof D));
        assertTrue(!(testEntity.e instanceof E));
        ReflectionMethods.initializeFieldsAtInject(testEntity);
        assertTrue((testEntity.d instanceof D));
        assertTrue((testEntity.e instanceof E));
    }

    @Test
    public void testSetDefaultsValues() throws IllegalAccessException, NoSuchFieldException {
        E c = new E();
        Class clazz = c.getClass();
        Field field = clazz.getDeclaredField("b");
        field.setAccessible(true);
        assertEquals(10, field.getByte(c));
        field.setAccessible(false);
        field = clazz.getDeclaredField("s");
        field.setAccessible(true);
        assertEquals(10, field.getShort(c));
        field.setAccessible(false);
        field = clazz.getDeclaredField("i");
        field.setAccessible(true);
        assertEquals(10, field.getInt(c));
        field.setAccessible(false);
        field = clazz.getDeclaredField("l");
        field.setAccessible(true);
        assertEquals(10, field.getLong(c));
        field.setAccessible(false);
        field = clazz.getDeclaredField("d");
        field.setAccessible(true);
        assertEquals(10, field.getDouble(c), 0);
        field.setAccessible(false);
        field = clazz.getDeclaredField("c");
        field.setAccessible(true);
        assertEquals('k', field.getChar(c));
        field.setAccessible(false);
        field = clazz.getDeclaredField("bool");
        field.setAccessible(true);
        assertEquals(true, field.getBoolean(c));
        field.setAccessible(false);
        field = clazz.getDeclaredField("objectField");
        field.setAccessible(true);
        assertEquals("test", field.get(c));
        field.setAccessible(false);
        // System.out.println(c);
        ReflectionMethods.setDefaultsValues(c);
        //System.out.println(c);
        field = clazz.getDeclaredField("b");
        field.setAccessible(true);
        assertEquals(0, field.getByte(c));
        field.setAccessible(false);
        field = clazz.getDeclaredField("s");
        field.setAccessible(true);
        assertEquals(0, field.getShort(c));
        field.setAccessible(false);
        field = clazz.getDeclaredField("i");
        field.setAccessible(true);
        assertEquals(0, field.getInt(c));
        field.setAccessible(false);
        field = clazz.getDeclaredField("l");
        field.setAccessible(true);
        assertEquals(0, field.getLong(c));
        field.setAccessible(false);
        field = clazz.getDeclaredField("d");
        field.setAccessible(true);
        assertEquals(0, field.getDouble(c), 0);
        field.setAccessible(false);
        field = clazz.getDeclaredField("c");
        field.setAccessible(true);
        assertEquals(0, field.getChar(c));
        field.setAccessible(false);
        field = clazz.getDeclaredField("bool");
        field.setAccessible(true);
        assertEquals(false, field.getBoolean(c));
        field.setAccessible(false);
        field = clazz.getDeclaredField("objectField");
        field.setAccessible(true);
        assertEquals(null, field.get(c));
        field.setAccessible(false);
    }
}
