package com.lhx.spring.step5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lihuaixin on 2019/7/18 16:20
 */
@Service
public class OrderService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public void addOrder() {
        jdbcTemplate.update("INSERT INTO t_order (amount,num) values (?,?) ", 10, 1);
        System.out.println("addOrder success.......");
    }

    @Transactional
    public void addOrder2() {
        jdbcTemplate.update("INSERT INTO t_order (amount,num) values (?,?) ", 10, 1);
        System.out.println("addOrder success.......");
        int i = 1 / 0;
    }
}
