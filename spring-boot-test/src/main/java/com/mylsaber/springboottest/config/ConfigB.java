package com.mylsaber.springboottest.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author jfw
 */
public class ConfigB {
    public void print() {
        System.out.println("configA中成功注入configB");
    }
}
