package com.lhx.spring.step4;

import com.lhx.spring.step4.aop.Calculator;
import com.lhx.spring.step4.config.RootConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by lihuaixin on 2019/7/16 10:47
 */
public class MainConfigTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);
        Calculator bean = applicationContext.getBean(Calculator.class);
        int div = bean.div(4, 3);
        System.out.println(div);
        System.out.println("IOC容器创建完成");
        applicationContext.close();
    }
}