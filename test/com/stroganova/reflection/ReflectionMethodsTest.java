package com.stroganova.reflection;

import com.stroganova.employeeservice.Manager;
import org.junit.Test;

public class ReflectionMethodsTest {

    @Test
    public void testPtintUnpublicMethos() {
        System.out.println("testPtintUnpublicMethos");
        ReflectionMethods.ptintUnpublicMethos(String.class);
        System.out.println();
    }

    @Test
    public void testGetInstanceOfClass() throws InstantiationException, IllegalAccessException {
        System.out.println("testGetInstanceOfClass");
        Object stringObject = ReflectionMethods.getInstanceOfClass(String.class);

        Class clazz = stringObject.getClass();
        System.out.println(clazz);
        System.out.println();
    }

    @Test
    public void testPrintMethodSignaturesWithFinal() {
        Manager m = new Manager();
        ReflectionMethods.printMethodSignaturesWithFinal(m);

    }


}
