package com.mylsaber.mybatismultidatasource.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author jfw
 */
@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.druid.one")
    public DataSource dataSourceOne() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.two")
    public DataSource dataSourceTwo() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public AbstractRoutingDataSource abstractRoutingDataSource() {
        HashMap<Object, Object> dataSources = new HashMap<Object, Object>() {{
            put("dataSource1", dataSourceOne());
            put("dataSource2", dataSourceTwo());
        }};
        return new MultiDataSource(dataSourceOne(), dataSources);
    }
}
