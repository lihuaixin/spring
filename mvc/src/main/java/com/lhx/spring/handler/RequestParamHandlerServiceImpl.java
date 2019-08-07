package com.lhx.spring.handler;

import com.lhx.spring.annotation.EnjoyService;
import com.lhx.spring.resolver.ArgumentResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lihuaixin on 2019/8/5 17:48
 */
@EnjoyService("requestParamHandlerService")
public class RequestParamHandlerServiceImpl implements RequestParamHandlerService {


    @Override
    public Object[] handler(HttpServletRequest request, HttpServletResponse response, Method method, Map<String, Object> beans) {
        if (method == null) {
            return null;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        Object[] args = new Object[parameterTypes.length];
        Map<String, Object> argReslovers = getInstanceType(beans, ArgumentResolver.class);
        int index = 0;
        int i = 0;
        for (Class<?> parameterType : parameterTypes) {
            for (Map.Entry<String, Object> entry : argReslovers.entrySet()) {
                ArgumentResolver reslovers = (ArgumentResolver) entry.getValue();
                if (reslovers.support(parameterType, index, method)) {
                    args[i++] = reslovers.argumentResolver(request, response, parameterType, index, method);
                }

            }
            index++;
        }
        return args;
    }

    private Map<String, Object> getInstanceType(Map<String, Object> beans, Class<?> type) {
        Map<String, Object> resultBeans = new HashMap<>();
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            Class<?>[] interfaces = entry.getValue().getClass().getInterfaces();
            for (Class<?> anInterface : interfaces) {
                if (anInterface.isAssignableFrom(type)) {
                    resultBeans.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return resultBeans;
    }
}
