package com.lhx.spring.step6;

import com.lhx.spring.step5.config.RootConfig;
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