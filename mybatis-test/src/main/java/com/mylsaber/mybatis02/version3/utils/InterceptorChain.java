package com.mylsaber.mybatis02.version3.utils;

import com.mylsaber.mybatis02.version3.Interceptor.Interceptor3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jfw
 */
public class InterceptorChain {
    private List<Interceptor3> interceptor3s = new ArrayList<>();

    public <T> T pluginAll(T target) {
        for (Interceptor3 interceptor3 : interceptor3s) {
            target = interceptor3.plugin(target);
        }
        return target;
    }

    public void addInterceptor(Interceptor3 interceptor3) {
        interceptor3s.add(interceptor3);
    }

    public void addInterceptor(Interceptor3... interceptor3s) {
        this.interceptor3s.addAll(Arrays.asList(interceptor3s));
    }
}
