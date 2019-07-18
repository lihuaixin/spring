/**
 * Tx 事务讲解
 * @EnableTransactionManagement
 * TransactionManagementConfigurationSelector
 *      AutoProxyRegistrar
 *          InfrastructureAdvisorAutoProxyCreator
 *      ProxyTransactionManagementConfiguration
 *          AnnotationTransactionAttributeSource
 *              SpringTransactionAnnotationParser
 *          TransactionInterceptor
 *              TransactionAspectSupport.invokeWithinTransaction()
 */
package com.lhx.spring.step5;