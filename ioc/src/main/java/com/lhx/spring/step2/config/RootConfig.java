package com.lhx.spring.step2.config;

import com.lhx.spring.step2.bean.Brid;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by lihuaixin on 2019/7/16 10:44
 */
@Configuration
@ComponentScan(value = {"com.lhx.spring.step2"})
@PropertySource("classpath:step2.properties")
public class RootConfig {
    @Bean
    public Brid brid(){
        return new Brid();
    }

}
