package com.chengzstory.orangeplay.annotation;

import java.lang.annotation.*;

/**
 * Created by chengzstory on 2018/2/28.
 */
@Documented
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {
}
