package com.mylsaber.proxy;

import org.junit.Test;

/**
 * @author jfw
 */
public class MainTest {
    @Test
    public void JdkProxyTest() {
        final JdkProxy.Animal monkey = new JdkProxy.Monkey();
        final JdkProxy.Animal proxy = JdkProxy.getProxy(monkey);
        proxy.run();
    }

    @Test
    public void CglibProxyTest() {
        final CglibProxy.Person person = new CglibProxy.Person();
        final CglibProxy.Person cglibProxy = CglibProxy.getCglibProxy(person);
        cglibProxy.say();
    }
}
