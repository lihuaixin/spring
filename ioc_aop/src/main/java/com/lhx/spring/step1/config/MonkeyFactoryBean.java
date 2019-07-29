package com.lhx.spring.step1.config;

import com.lhx.spring.step1.bean.Monkey;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by lihuaixin on 2019/7/15 14:50
 */
public class MonkeyFactoryBean implements FactoryBean<Monkey> {
    public Monkey getObject() throws Exception {
        return new Monkey();
    }

    public Class<?> getObjectType() {
        return Monkey.class;
    }
}
