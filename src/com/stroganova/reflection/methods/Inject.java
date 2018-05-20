package com.stroganova.reflection.methods;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
    Class clazz() default Void.class;

}
