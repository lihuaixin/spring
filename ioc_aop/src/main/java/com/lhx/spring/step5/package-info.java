/**
 * Tx 事务讲解 跟AOP密切相关
 * @EnableTransactionManagement
 * TransactionManagementConfigurationSelector
 *      AutoProxyRegistrar implements ImportBeanDefinitionRegistrar
 *          注册了一个RootBeanDefinition InfrastructureAdvisorAutoProxyCreator
 *      ProxyTransactionManagementConfiguration
 *          AnnotationTransactionAttributeSource
 *              SpringTransactionAnnotationParser
 *          TransactionInterceptor
 *              TransactionAspectSupport.invokeWithinTransaction() 执行事务的开始，提交，回滚等操作
 */
package com.lhx.spring.step5;