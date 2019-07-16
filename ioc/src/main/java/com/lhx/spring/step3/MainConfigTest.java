package com.lhx.spring.step3;

import com.lhx.spring.step3.config.RootConfig;
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
        applicationContext.close();
    }
}