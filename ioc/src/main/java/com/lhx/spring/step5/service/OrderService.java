package com.lhx.spring.step5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by lihuaixin on 2019/7/18 16:20
 */
@Service
public class OrderService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addOrder() {
        jdbcTemplate.update("", 1);
        System.out.println("addOrder success.......");
    }
}
