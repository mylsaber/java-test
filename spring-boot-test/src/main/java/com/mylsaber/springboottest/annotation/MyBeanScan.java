package com.mylsaber.springboottest.annotation;

import com.mylsaber.springboottest.registrar.MyBeanRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jfw
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({MyBeanRegistrar.class})
public @interface MyBeanScan {
    String[] basePackage() default {};
}
