package com.lhx.spring.step6.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by lihuaixin on 2019/7/19 15:22
 */
@Component
public class JamesBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("JamesBeanFactoryPostProcessor 调用了postProcessBeanFactory.......");
        //所有Bean的定义，已经加载到beanFactory，但是bean实例还没创建
        int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("当前beanDefinitionCount:" + beanDefinitionCount);
        System.out.println("当前beanDefinitionNames:" + Arrays.toString(beanDefinitionNames));
    }
}
