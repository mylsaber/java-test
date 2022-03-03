package com.mylsaber.mybatis02;

import com.mylsaber.mybatis02.service.HelloService;
import com.mylsaber.mybatis02.service.impl.HelloServiceImpl;
import com.mylsaber.mybatis02.version1.ProxyHandler1;
import com.mylsaber.mybatis02.version2.Interceptor.impl.LogInterceptorImpl2;
import com.mylsaber.mybatis02.version2.handler.ProxyHandler2;
import com.mylsaber.mybatis02.version3.Interceptor.impl.LogInterceptorImpl3;
import com.mylsaber.mybatis02.version3.utils.InterceptorChain;
import com.mylsaber.mybatis02.version4.interceptor.impl.TxInterceptorImpl4;
import com.mylsaber.mybatis02.version4.interceptor.impl.LogInterceptorImpl4;
import com.mylsaber.mybatis02.version4.utils.InterceptorChain4;
import org.junit.Before;
import org.junit.Test;

/**
 * @author jfw
 */
public class MainTest {
    private HelloService helloService;

    @Before
    public void before() {
        helloService = new HelloServiceImpl();
    }

    @Test
    public void version1Test() {
        final HelloService wrap = ProxyHandler1.wrap(helloService);
        wrap.sayHello();
    }

    @Test
    public void version2Test() {
        final LogInterceptorImpl2 logInterceptorImpl2 = new LogInterceptorImpl2();
        final HelloService wrap = ProxyHandler2.wrap(helloService, logInterceptorImpl2);
        wrap.sayHello();
    }

    @Test
    public void version3Test() {
        final LogInterceptorImpl3 logInterceptorImpl3 = new LogInterceptorImpl3();
        final HelloService plugin = logInterceptorImpl3.plugin(helloService);
        plugin.sayHello();

        System.out.println("--------------------");

        final InterceptorChain interceptorChain = new InterceptorChain();
        interceptorChain.addInterceptor(logInterceptorImpl3);
        final HelloService helloService = interceptorChain.pluginAll(this.helloService);
        helloService.sayHello();
    }

    @Test
    public void version4Test() {
        final LogInterceptorImpl4 logInterceptorImpl4 = new LogInterceptorImpl4();
        final HelloService plugin = logInterceptorImpl4.plugin(helloService);
        final TxInterceptorImpl4 txInterceptorImpl4 = new TxInterceptorImpl4();
        final HelloService plugin1 = txInterceptorImpl4.plugin(plugin);
        plugin1.sayHello();

        System.out.println("--------------------");

        final InterceptorChain4 interceptorChain4 = new InterceptorChain4();
        interceptorChain4.addInterceptor(logInterceptorImpl4,txInterceptorImpl4);
        final HelloService helloService = interceptorChain4.pluginAll(this.helloService);
        helloService.sayHello();
    }
}
