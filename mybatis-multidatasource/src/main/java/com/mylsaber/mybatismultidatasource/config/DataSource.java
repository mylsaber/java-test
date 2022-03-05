package com.mylsaber.mybatismultidatasource.config;

import java.lang.annotation.*;

/**
 * @author jfw
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String DB() default "dataSource1";
}
