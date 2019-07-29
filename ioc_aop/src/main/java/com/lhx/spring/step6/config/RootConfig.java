package com.lhx.spring.step6.config;

import com.lhx.spring.step6.bean.Moon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lihuaixin on 2019/7/16 14:36
 */
@Configuration
@ComponentScan(value = {"com.lhx.spring.step6"})
public class RootConfig {

    @Bean
    public Moon getMoon() {
        return new Moon();
    }

}
