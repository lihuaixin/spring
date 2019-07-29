package com.lhx.spring.step1.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by lihuaixin on 2019/7/15 16:07
 */
@Component
public class Plane implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    public Plane() {
        System.out.println("Plane Constructor……");
    }

    @PostConstruct
    public void init(){
        System.out.println("Plane init  @PostConstruct……");
    }

    @PreDestroy
    public void destory(){
        System.out.println("Plane destory @PreDestroy……");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
