package com.mylsaber.springboottest.annotation;

import com.mylsaber.springboottest.registrar.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author jfw
 */
@Retention(RetentionPolicy.RUNTIME)
@Import({MyImportBeanDefinitionRegistrar.class})
public @interface EnableConfigD {}
