package com.mylsaber.springboottest.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;

/**
 * @author jfw
 */
public class ConfigB implements BeanPostProcessor {
    public ConfigB() {
        System.out.println("实例化B");
    }

    public void print() {
        System.out.println("configA中成功注入configB");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("--------------------postProcessBeforeInitialization:"+beanName+"-----------------------");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("--------------------postProcessAfterInitialization:"+beanName+"--------------------------");
        return bean;
    }
}
