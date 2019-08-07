package com.lhx.spring.resolver;

import com.lhx.spring.annotation.EnjoyService;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by lihuaixin on 2019/8/7 13:55
 */
@EnjoyService("httpServletResponseArgumentResolver")
public class HttpServletResponseArgumentResolverImpl implements ArgumentResolver {
    @Override
    public boolean support(Class<?> type, int index, Method method) {
        return ServletResponse.class.isAssignableFrom(type);
    }

    @Override
    public Object argumentResolver(HttpServletRequest request, HttpServletResponse response, Class<?> type, int index, Method method) {
        return response;
    }
}
