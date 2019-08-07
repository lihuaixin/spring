package com.lhx.spring.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by lihuaixin on 2019/8/7 13:50
 */
public interface ArgumentResolver {
    /**
     * 判断是否为当前需要解析的类
     */
    boolean support(Class<?> type, int index, Method method);

    /**
     * 参数解析
     */
    Object argumentResolver(HttpServletRequest request, HttpServletResponse response, Class<?> type, int index, Method method);
}
