package com.lhx.spring.step6.processor;

import com.lhx.spring.step6.bean.Moon;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

/**
 * Created by lihuaixin on 2019/7/25 16:02
 */
@Component
public class JamesBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("调用JamesBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry(),bean的数量"
                + registry.getBeanDefinitionCount());
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Moon.class);
        registry.registerBeanDefinition("hello", rootBeanDefinition);

        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Moon.class).getBeanDefinition();
        registry.registerBeanDefinition("hello2", beanDefinition);
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("调用JamesBeanDefinitionRegistryPostProcessor.postProcessBeanFactory(),bean的数量"
                + beanFactory.getBeanDefinitionCount());
    }
}
