/**
 * bean 对象的注册到容器,容器创建单实例bean
 * 1.容器启动加载配置类
 * 2.调用容器AbstractApplicationContext.refresh()
 * AbstractApplicationContext.finishBeanFactoryInitialization() 创建单实例bean
 * AbstractBeanFactory.preInstantiateSingletons()--AbstractBeanFactory.getBean()-->AbstractBeanFactory.doCreateBean()--->
 * AbstractAutowireCapableBeanFactory.createBean()--->AbstractAutowireCapableBeanFactory.doCreateBean()--->
 * AbstractAutowireCapableBeanFactory.createBeanInstance() beanWrapper对象被创建--->
 * AbstractAutowireCapableBeanFactory.populateBean()bean属性赋值--->AbstractAutowireCapableBeanFactory.initializeBean()方法初始化并
 * --->AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization() 前置处理 执行AbstractAutowireCapableBeanFactory.initMethod方法
 * --->AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsAfterInitialization() 后置处理
 * Created by lihuaixin on 2019/7/16 14:10
 */
package com.lhx.spring.step1;