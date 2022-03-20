package com.chengh.spingmvc;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//注解使用在参数上
@Target(ElementType.PARAMETER)
public @interface TestAnnotation {
    String value() default "";
}
