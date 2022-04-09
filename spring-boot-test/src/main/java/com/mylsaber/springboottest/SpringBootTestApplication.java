package com.mylsaber.springboottest;

import com.mylsaber.springboottest.annotation.EnableConfigD;
import com.mylsaber.springboottest.annotation.MyBeanScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author jfw
 */
@SpringBootApplication
@EnableConfigD
@MyBeanScan(basePackage = {"com.mylsaber.springboottest.config"})
@Import(FactoryPostProcessor.class)
public class SpringBootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestApplication.class, args);
    }

}
