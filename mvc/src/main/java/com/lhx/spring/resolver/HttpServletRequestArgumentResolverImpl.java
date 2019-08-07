package com.lhx.spring.resolver;

import com.lhx.spring.annotation.EnjoyService;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by lihuaixin on 2019/8/7 13:55
 */
@EnjoyService("httpServletRequestArgumentResolver")
public class HttpServletRequestArgumentResolverImpl implements ArgumentResolver {
    @Override
    public boolean support(Class<?> type, int index, Method method) {
        return ServletRequest.class.isAssignableFrom(type);
    }

    @Override
    public Object argumentResolver(HttpServletRequest request, HttpServletResponse response, Class<?> type, int index, Method method) {
        return request;
    }
}
