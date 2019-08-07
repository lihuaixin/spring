package com.lhx.spring.resolver;

import com.lhx.spring.annotation.EnjoyRequestParam;
import com.lhx.spring.annotation.EnjoyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by lihuaixin on 2019/8/7 13:55
 */
@EnjoyService("enjoyRequestParamArgumentResolver")
public class EnjoyRequestParamArgumentResolverImpl implements ArgumentResolver {
    @Override
    public boolean support(Class<?> type, int index, Method method) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Annotation[] parameterAnnotation = parameterAnnotations[index];
        for (Annotation annotation : parameterAnnotation) {
            if (EnjoyRequestParam.class.isAssignableFrom(annotation.getClass())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object argumentResolver(HttpServletRequest request, HttpServletResponse response, Class<?> type, int index, Method method) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Annotation[] parameterAnnotation = parameterAnnotations[index];
        for (Annotation annotation : parameterAnnotation) {
            if (EnjoyRequestParam.class.isAssignableFrom(annotation.getClass())) {
                EnjoyRequestParam enjoyRequestParam = (EnjoyRequestParam) annotation;
                String value = enjoyRequestParam.value();
                return request.getParameter(value);
            }
        }
        return null;
    }
}
