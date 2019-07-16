package com.lhx.spring.step1.config;

import com.lhx.spring.step1.bean.Bike;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by lihuaixin on 2019/7/15 14:45
 */
@Configuration
@ComponentScan(basePackages = {"com.lhx.spring.step1.bean"})
@Import(value = {DogImportSelector.class, PigImportBeanDefinitionRegistrar.class})
public class RootConfig {
    @Bean
    MonkeyFactoryBean monkeyFactoryBean() {
        return new MonkeyFactoryBean();
    }

    @Bean(initMethod = "init", destroyMethod = "destory")
    public Bike bike() {
        return new Bike();
    }
}
