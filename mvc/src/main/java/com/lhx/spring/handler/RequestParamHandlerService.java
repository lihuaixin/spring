package com.lhx.spring.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by lihuaixin on 2019/8/5 17:50
 */
public interface RequestParamHandlerService {
    Object[] handler(HttpServletRequest request, HttpServletResponse response, Method method, Map<String, Object> beans);
}
