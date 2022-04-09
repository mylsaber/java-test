package com.mylsaber.springboottest.registrar;

import com.mylsaber.springboottest.config.ConfigD;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author jfw
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println("Registrar");
        final String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        System.out.println("-------------MyImportBeanDefinitionRegistrar----------------");
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("Registrar");
        System.out.println("-------------MyImportBeanDefinitionRegistrar----------------");
        final RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(ConfigD.class);
        rootBeanDefinition.setInitMethodName("initMethod");
        registry.registerBeanDefinition("MyConfigD", rootBeanDefinition);
    }
}
