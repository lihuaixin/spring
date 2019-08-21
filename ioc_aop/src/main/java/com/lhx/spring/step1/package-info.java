/**
 * BeanPostProcessor  Bean后置处理器，它是Spring中定义的接口，在Spring容器的创建过程中（具体为Bean初始化前后）会回调BeanPostProcessor中定义的两个方法。在bean创建时期调用
 * ImportSelector  spring中导入外部配置的核心接口，在SpringBoot的自动化配置和@EnableXXX(功能性注解)都有它的存在,BeanFactoryPostProcessor接口的子接口BeanDefinitionRegistryPostProcessor来实现的。
 * ImportBeanDefinitionRegistrar
 *
 * bean 对象的注册到容器,容器创建单实例bean
 * 1.容器启动加载配置类
 * 2.调用容器AbstractApplicationContext.refresh()
 * AbstractApplicationContext.finishBeanFactoryInitialization() 创建单实例bean
 * AbstractBeanFactory.preInstantiateSingletons()-->AbstractBeanFactory.getBean()-->AbstractBeanFactory.doCreateBean()--->
 * AbstractAutowireCapableBeanFactory.createBean()--->AbstractAutowireCapableBeanFactory.doCreateBean()--->
 * AbstractAutowireCapableBeanFactory.createBeanInstance() beanWrapper对象被创建--->
 * AbstractAutowireCapableBeanFactory.populateBean()bean属性赋值--->AbstractAutowireCapableBeanFactory.initializeBean()方法初始化并
 * --->AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization() 前置处理 执行AbstractAutowireCapableBeanFactory.initMethod方法
 * --->AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsAfterInitialization() 后置处理
 * Created by lihuaixin on 2019/7/16 14:10
 */
package com.lhx.spring.step1;