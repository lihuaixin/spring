package com.lhx.proxy.cglib;

import com.lhx.proxy.User;

/**
 * Created by lihuaixin on 2019/8/26 17:02
 */
public class UserServiceImpl {
    public User findUser(Long id) {
        return new User(id, "张三");
    }
}
