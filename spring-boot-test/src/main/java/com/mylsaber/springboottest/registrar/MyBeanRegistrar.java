package com.mylsaber.springboottest.registrar;

import com.mylsaber.springboottest.annotation.MyBean;
import com.mylsaber.springboottest.annotation.MyBeanScan;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * @author jfw
 */
public class MyBeanRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        final AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(MyBeanScan.class.getName()));
        assert annotationAttributes != null;
        final String[] basePackages = annotationAttributes.getStringArray("basePackage");

        final ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry, true);
        scanner.addIncludeFilter(new AnnotationTypeFilter(MyBean.class));
        scanner.scan(basePackages);
    }

}
