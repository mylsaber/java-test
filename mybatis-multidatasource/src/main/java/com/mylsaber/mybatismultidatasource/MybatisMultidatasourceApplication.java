package com.mylsaber.mybatismultidatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author jfw
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.mylsaber.mybatismultidatasource.dao")
public class MybatisMultidatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisMultidatasourceApplication.class, args);
    }

}
