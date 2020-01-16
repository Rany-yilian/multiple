package com.im.api.spi;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Spi {

    String value() default "";

    int order() default 0;
}
