/**
 * Tx 事务讲解 跟AOP密切相关
 * @EnableTransactionManagement
 * TransactionManagementConfigurationSelector
 *      AutoProxyRegistrar implements ImportBeanDefinitionRegistrar
 *          注册了一个RootBeanDefinition InfrastructureAdvisorAutoProxyCreator  该类的父类继承了AbstractAutoProxyCreator，当spring容器创建bean的时候,该bean执行后置处理器创建了代理对象。
 *      ProxyTransactionManagementConfiguration定义了三个bean
 *          BeanFactoryTransactionAttributeSourceAdvisor 就是被扫描的Advisor类。这个类会扫面被Transactional注释的类的方法，并提供TransactionInterceptor，来代理被注释的方法
 *          AnnotationTransactionAttributeSource 负责解析Transactional注释的属性，如回滚，事务隔离级别，传播属性等
 *              SpringTransactionAnnotationParser
 *          TransactionInterceptor 主要负责控制事务的操作，这些操作在父类TransactionAspectSupport.invokeWithinTransaction()方法中
 *          ，该方法获取事务属性，事务管理器，创建事务，执行事务方法，提交事务或回滚事务，并返回事务方法的返回值
 *
 */
package com.lhx.spring.step5;