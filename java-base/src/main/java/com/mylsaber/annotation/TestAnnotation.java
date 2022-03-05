package com.mylsaber.annotation;

import java.lang.annotation.*;

/**
 * @author jfw
 */
//标记注解作用范围
@Target({ElementType.FIELD,ElementType.METHOD})
//注解存活时间
@Retention(RetentionPolicy.RUNTIME)
//将注解中的元素包含到文档中
@Documented
//类继承关系中，子类会继承父类使用的注解中被@Inherited修饰的注解，接口无效
@Inherited
public @interface TestAnnotation {
}
