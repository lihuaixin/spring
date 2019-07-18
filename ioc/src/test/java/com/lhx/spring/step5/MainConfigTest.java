package com.lhx.spring.step5;

import com.lhx.spring.step5.config.RootConfig;
import com.lhx.spring.step5.service.OrderService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by lihuaixin on 2019/7/16 10:47
 */
public class MainConfigTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);
        System.out.println("IOC容器创建完成");
        OrderService bean = applicationContext.getBean(OrderService.class);
        bean.addOrder();
        applicationContext.close();
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);
        System.out.println("IOC容器创建完成");
        OrderService bean = applicationContext.getBean(OrderService.class);
        bean.addOrder2();
        applicationContext.close();
    }
}