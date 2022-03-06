package com.mylsaber.springboottest.scanner;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

/**
 * @author jfw
 */
public class MyBeanScanner extends ClassPathBeanDefinitionScanner {
    public MyBeanScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
        super(registry, useDefaultFilters);
    }
}
