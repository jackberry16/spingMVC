package com.chengh.spingmvc;

import org.springframework.web.bind.annotation.ValueConstants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test2Annotation {
    //参数绑定的变量名
    String name() default "test2";

    //参数是否必须
    boolean required() default true;

    //没有获取到请求参数的时候的默认值
    String defaultValue() default ValueConstants.DEFAULT_NONE;


}
