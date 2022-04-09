package com.mylsaber.springboottest.config;

import com.mylsaber.springboottest.annotation.MyBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jfw
 */
@MyBean
public class ConfigA {

    private ConfigB configB;

    public ConfigA() {
        System.out.println("实例化A");
    }

    public ConfigB getConfigB() {
        return configB;
    }

    @Autowired
    public void setConfigB(ConfigB configB) {
        this.configB = configB;
    }

    public void print() {
        System.out.println("configA");
    }
}
