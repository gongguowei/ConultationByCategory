package com.aircos.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 专业搜索切入点
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryProfessionLogPoint {
    String value() default "";
}