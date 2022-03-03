package com.mylsaber.mybatis02.version4.utils;

import com.mylsaber.mybatis02.version4.interceptor.Interceptor4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jfw
 */
public class InterceptorChain4 {
    private List<Interceptor4> interceptor4s = new ArrayList<>();

    public <T> T pluginAll(T target) {
        for (Interceptor4 interceptor4 : interceptor4s) {
            target = interceptor4.plugin(target);
        }
        return target;
    }

    public void addInterceptor(Interceptor4 interceptor4) {
        interceptor4s.add(interceptor4);
    }

    public void addInterceptor(Interceptor4... interceptor4) {
        interceptor4s.addAll(Arrays.asList(interceptor4));
    }
}
