package com.mylsaber.springboottest;

import com.mylsaber.springboottest.config.ConfigA;
import com.mylsaber.springboottest.config.ConfigB;
import com.mylsaber.springboottest.config.ConfigC;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringBootTestApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;
    @Test
    void contextLoads() {
        System.out.println(applicationContext.getBean(ConfigA.class));
        System.out.println(applicationContext.getBean(ConfigB.class));
        System.out.println(applicationContext.getBean(ConfigC.class));
        System.out.println(applicationContext.getBean("MyConfigD"));

        System.out.println("-----------------------");
        final ConfigA bean = applicationContext.getBean(ConfigA.class);
        bean.getConfigB().print();
    }

}
