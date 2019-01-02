package com.wewe.designpattern.simplefactory.annotation;

import java.lang.annotation.*;

/**
 * Author: fei2
 * Date:  18-8-9 下午7:29
 * Description:车辆注解
 * Refer To:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Vehicle {
    String type() default "";
}
