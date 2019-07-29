package com.lhx.spring.step1;

import com.lhx.spring.step1.bean.Monkey;
import com.lhx.spring.step1.config.RootConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by lihuaixin on 2019/7/16 10:52
 */
public class MainConfigTest {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);
        System.out.println("容器启动完成……");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        //获取的是bean 实例是monkey实例
        Object bean = applicationContext.getBean("monkeyFactoryBean");
        System.out.println("bean is monkey:" + bean.getClass().equals(Monkey.class));

        applicationContext.getBean("bike");

        applicationContext.close();
    }
}