package com.lhx.spring.annotation;

import java.lang.annotation.*;

/**
 * Created by lihuaixin on 2019/8/5 16:27
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnjoyRequestParam {
    String value() default "";
}
