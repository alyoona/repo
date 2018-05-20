package com.stroganova.reflection.querygenerator;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String name() default "";
}
