package com.mylsaber.springboottest.config;

/**
 * @author jfw
 */
public class ConfigD {
    public ConfigD() {
        System.out.println("实例化D");
    }
    public void initMethod() {
        System.out.println("configB的init方法");
    }

    public void print() {
        System.out.println("configD");
    }
}
