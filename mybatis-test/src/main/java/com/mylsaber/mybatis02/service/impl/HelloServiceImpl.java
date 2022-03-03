package com.mylsaber.mybatis02.service.impl;

import com.mylsaber.mybatis02.service.HelloService;

/**
 * @author jfw
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        System.out.println("hello world");
        return "hello world";
    }
}
