/**
 * {@link org.springframework.beans.factory.config.BeanFactoryPostProcessor} beanFactory 后置处理器
 * {@link org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor } 执行时机在BeanFactoryPostProcessor 之前执行
 * 源码：
 * refresh();
 * invokeBeanFactoryPostProcessors(beanFactory);
 *      PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(beanFactory, getBeanFactoryPostProcessors());
 *          首先处理实现了BeanDefinitionRegistryPostProcessor 处理器
 *              首先，调用实现PriorityOrdered的BeanDefinitionRegistryPostProcessors.postProcessBeanDefinitionRegistry()
 *              接下来，调用实现Ordered的BeanDefinitionRegistryPostProcessors.postProcessBeanDefinitionRegistry()
 *              最后，调用所有其他BeanDefinitionRegistryPostProcessors.postProcessBeanDefinitionRegistry()，直到不再出现其他处理器。
 *              随后，调用到目前为止处理的所有处理器的postProcessBeanFactory()方法
 *          随后处理实现了BeanFactoryPostProcessor 处理器
 *              首先，调用实现PriorityOrdered的BeanFactoryPostProcessor。
 *              接下来，调用实现Ordered的BeanFactoryPostProcessor。
 *              最后，调用所有其他BeanFactoryPostProcessor。
 *
 * springIOC容器的创建refresh()[创建刷新]
 * 	1. prepareRefresh();
 * 	   1.1 initPropertySources();初始化属性设置，由子类进行进行实现
 * 	   1.2 getEnvironment().validateRequiredProperties();  校验相关属性的合法性
 * 	   1.3 this.earlyApplicationEvents = new LinkedHashSet<>(); 保存容器中一起早期的事件
 *
 * 	2. ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();获取beanFactory实例
 * 	    2.1 refreshBeanFactory();刷新或创建beanFactory
 * 	    2.2 getBeanFactory() 返回beanFactory
 *
 * 	3.	prepareBeanFactory(beanFactory); beanFactory与准备工作，第2步创建的beanFactory 好多属性没有值，或只有默认值
 * 	    beanFactory.setBeanClassLoader(getClassLoader()); 设置类加载器
 * 		beanFactory.setBeanExpressionResolver(new StandardBeanExpressionResolver(beanFactory.getBeanClassLoader())); 设置表达式语言的解析器
 * 		beanFactory.addPropertyEditorRegistrar(new ResourceEditorRegistrar(this, getEnvironment()));添加要应用于所有bean创建过程的propertyEditor或regstrar
 * 		beanFactory.ignoreDependencyInterface(EnvironmentAware.class); 设置忽略的自动装配接口aware ApplicationContextAware ，ApplicationEventPublisherAware等
 * 	    beanFactory.registerResolvableDependency(BeanFactory.class, beanFactory); 注册可以解析的自动装配，能直接在任何组建中自动注入beanFactory ApplicationContext等
 * 	    beanFactory.addBeanPostProcessor(new ApplicationListenerDetector(this)); 添加监听器的后置处理器
 *      beanFactory.registerSingleton(ENVIRONMENT_BEAN_NAME, getEnvironment()); 注册默认环境bean
 *
 *  4.postProcessBeanFactory(beanFactory)准备工作完成后进行的后置处理工作
 *      子类通过重写这个方法在BeanFactory创建完成后做进一步的自定义处理
 *
 *  5.invokeBeanFactoryPostProcessors(beanFactory);
 *        PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(beanFactory, getBeanFactoryPostProcessors());
 *            首先处理实现了BeanDefinitionRegistryPostProcessor 处理器
 *                首先，调用实现PriorityOrdered的BeanDefinitionRegistryPostProcessors.postProcessBeanDefinitionRegistry()
 *                接下来，调用实现Ordered的BeanDefinitionRegistryPostProcessors.postProcessBeanDefinitionRegistry()
 *                最后，调用所有其他BeanDefinitionRegistryPostProcessors.postProcessBeanDefinitionRegistry()，直到不再出现其他处理器。
 *                随后，调用到目前为止处理的所有处理器的postProcessBeanFactory()方法
 *            随后处理实现了BeanFactoryPostProcessor 处理器
 *                首先，调用实现PriorityOrdered的BeanFactoryPostProcessor。
 *                接下来，调用实现Ordered的BeanFactoryPostProcessor。
 *                最后，调用所有其他BeanFactoryPostProcessor
 *
 *  6.registerBeanPostProcessors(beanFactory);注册拦截bean创建的BeanPostProcessor,AOP 拦截bean处理器在此时创建。主要对bean拦截器进行创建
 *      SmartInstantiationAwareBeanPostProcessor---->InstantiationAwareBeanPostProcessor--->BeanPostProcessor
 *      AOP AnnotationAwareAspectJAutoProxyCreator 父类的父类实现了SmartInstantiationAwareBeanPostProcessor
 *      首先，注册实现PriorityOrdered的BeanPostProcessor
 *      接下来，注册实现Ordered的BeanPostProcessor
 *      最后，注册所有其他BeanPostProcessor
 *
 *  7.initMessageSource();初始化messageSource组件，（国际化功能：消息解析，消息绑定）
 *      判断是否有bean Id 为messageSource ，如果没有自己创建一个this.messageSource = new DelegatingMessageSource();
 *      并使用beanFactory.registerSingleton(messageSource, this.messageSource); 注册成单实例bean
 *
 *  8.initApplicationEventMulticaster(); 初始化事件派发器
 *      获取beanFactory，判断beanFactory是否有 beanid 为applicationEventMulticaster 事件派发器，
 *      如果没有创建一个派发器this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
 *      并使用beanFactory.registerSingleton(applicationEventMulticaster, this.applicationEventMulticaster);; 注册成单实例bean
 *
 *  9.onRefresh(); 留给子容器（子类）：子类可以重写这个方法在容器刷新的时候可以自定义逻辑
 *
 *  10.registerListeners();给容器中所有项目里面ApplicationListener注册进来
 *      从IOC容器中拿到所有的ApplicationListener
 *      getApplicationEventMulticaster().multicastEvent(earlyEvent); 进行事件派发
 *
 *  11.finishBeanFactoryInitialization(beanFactory);
 *
 * 	12.finishRefresh();
 *
 **/
package com.lhx.spring.step6;