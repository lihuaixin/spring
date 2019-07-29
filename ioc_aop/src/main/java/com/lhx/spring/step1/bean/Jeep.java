package com.lhx.spring.step1.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by lihuaixin on 2019/7/15 16:07
 */
@Component
public class Jeep {
    public Jeep() {
        System.out.println("jeep Constructor……");
    }

    @PostConstruct
    public void init(){
        System.out.println("jeep init  @PostConstruct……");
    }

    @PreDestroy
    public void destory(){
        System.out.println("jeep destory @PreDestroy……");
    }
}
