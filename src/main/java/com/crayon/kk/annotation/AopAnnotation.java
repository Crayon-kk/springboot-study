package com.crayon.kk.annotation;

import java.lang.annotation.*;

/**
 * 手写注解用于测试aop
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AopAnnotation {

    String value() default "";

}
