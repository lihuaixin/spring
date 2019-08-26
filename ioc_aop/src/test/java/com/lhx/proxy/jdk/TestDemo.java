package com.lhx.proxy.jdk;

import com.lhx.proxy.User;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by lihuaixin on 2019/8/26 16:47
 */
public class TestDemo {
    @Test
    public void test() {
        User user = new User();
        user.setName("zhangsan");
        UserService us = new UserServiceImpl();
        UserServiceInterceptor userServiceInterceptor = new UserServiceInterceptor(us);
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(us.getClass().getClassLoader(), us.getClass().getInterfaces(), userServiceInterceptor);

        userServiceProxy.addUser(user);

        User user2 = new User();
        user2.setName("1");
        userServiceProxy.addUser(user2);

    }
}
