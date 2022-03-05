package com.mylsaber.mybatismultidatasource.config;

import com.mylsaber.mybatismultidatasource.utils.SwitchDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author jfw
 */
@Aspect
@Component
public class DataSourceAspect {
    @Pointcut("@annotation(com.mylsaber.mybatismultidatasource.config.DataSource)")
    public void DataSourcePoint() {
    }

    @Around("DataSourcePoint()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        DataSource dataSource = method.getAnnotation(DataSource.class);
        if (dataSource == null) {
            SwitchDataSource.setDataSource("dataSource1");
        } else {
            SwitchDataSource.setDataSource(dataSource.DB());
        }

        try {
            return point.proceed();
        } finally {
            SwitchDataSource.toDefault();
        }
    }
}
