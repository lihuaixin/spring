package com.lhx.proxy.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by lihuaixin on 2019/8/26 17:04
 */
public class UserServiceImplInterceptor implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (objects != null && objects.length > 0 && objects[0] instanceof Long) {
            Long id = (Long) objects[0];
            if (id < 1) {
                throw new RuntimeException("id需要大于0");
            }
        }
        Object ret = methodProxy.invokeSuper(o, objects);
        return ret;
    }
}
