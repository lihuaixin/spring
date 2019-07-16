package com.lhx.spring.step2;

import com.lhx.spring.step2.bean.Brid;
import com.lhx.spring.step2.config.RootConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by lihuaixin on 2019/7/16 10:47
 */
public class MainConfigTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        Brid brid = applicationContext.getBean(Brid.class);
        System.out.println(brid);
        System.out.println("IOC容器创建完成");
        applicationContext.close();
    }
}