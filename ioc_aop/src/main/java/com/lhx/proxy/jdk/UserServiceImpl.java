package com.lhx.proxy.jdk;

import com.lhx.proxy.User;

/**
 * Created by lihuaixin on 2019/8/26 16:40
 */
public class UserServiceImpl implements UserService {
    public void addUser(User user) {
        System.out.println("addUser succes!!");
    }
}
