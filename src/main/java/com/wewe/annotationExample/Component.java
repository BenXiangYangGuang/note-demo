package com.wewe.annotationExample;

import java.lang.annotation.*;

/**
 * Author: wewe
 * Date:  18-8-18 上午11:05
 * Description:定义一个组件
 * Refer To:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Component {

    String identifier() default "";

}
