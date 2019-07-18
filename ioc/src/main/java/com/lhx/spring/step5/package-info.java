/**
 * Tx 事务讲解
 * @EnableTransactionManagement
 * TransactionManagementConfigurationSelector
 *      AutoProxyRegistrar implements ImportBeanDefinitionRegistrar
 *          注册了一个RootBeanDefinition InfrastructureAdvisorAutoProxyCreator
 *      ProxyTransactionManagementConfiguration
 *          AnnotationTransactionAttributeSource
 *              SpringTransactionAnnotationParser
 *          TransactionInterceptor
 *              TransactionAspectSupport.invokeWithinTransaction()
 */
package com.lhx.spring.step5;