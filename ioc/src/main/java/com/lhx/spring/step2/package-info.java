/**
 * 介绍注解使用
 * @see @Value
 * @see @PropertySource("classpath:step2.properties")
 * @see @Autowired 自动注入bean支持不存在bean时注入不会报错，声名的bean名称找不到会按类型找
 * @see @Resource  自动注入bean 不能为空 JSR250标准注解
 * @see @Inject    自动注入 不能为空，javax.inject包需要额外导入包
 * @see @Qualifier 当多个beanid 时可以指定注入beanId
 * @see @Primary 当多个相同bean指定优先使用
 *  Created by lihuaixin on 2019/7/16 14:09
 */
package com.lhx.spring.step2;