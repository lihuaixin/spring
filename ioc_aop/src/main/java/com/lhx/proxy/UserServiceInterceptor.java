package com.lhx.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by lihuaixin on 2019/8/26 16:41
 */
public class UserServiceInterceptor implements InvocationHandler {
    private Object realObj;

    public UserServiceInterceptor(Object realObj) {
        super();
        this.realObj = realObj;
    }

    public UserServiceInterceptor() {
        super();
    }

    public Object getRealObj() {
        return realObj;
    }

    public void setRealObj(Object realObj) {
        this.realObj = realObj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (args != null && args.length > 0 && args[0] instanceof User) {
            User user = (User) args[0];
            if (user.getName().trim().length() <= 1) {
                throw new RuntimeException("姓名不能为空，长度需要大于1");
            }
        }
        Object ret = method.invoke(realObj, args);
        System.out.println("添加成功");
        return ret;
    }
}
