package com.lhx.proxy.cglib;

import com.lhx.proxy.User;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by lihuaixin on 2019/8/26 16:47
 */
public class TestDemo {
    @Test
    public void test() {
        UserServiceImplInterceptor userServiceInterceptor = new UserServiceImplInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(userServiceInterceptor);
        UserServiceImpl usi = (UserServiceImpl) enhancer.create();

        User user = usi.findUser(1L);
        System.out.println(user.getName());
    }
}
