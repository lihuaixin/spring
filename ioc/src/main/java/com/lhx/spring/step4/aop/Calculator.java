package com.lhx.spring.step4.aop;

import org.springframework.stereotype.Component;

/**
 * Created by lihuaixin on 2019/7/16 15:34
 */
@Component
public class Calculator {
    public int div(int i, int j) {
        return i / j;
    }
}
