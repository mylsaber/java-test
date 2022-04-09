package com.mylsaber.seatetest;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Random;

/**
 * @author jfw
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableAutoDataSourceProxy
public class SeataTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataTestApplication.class, args);
    }

}
