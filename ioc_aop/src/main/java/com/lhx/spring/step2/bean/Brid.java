package com.lhx.spring.step2.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by lihuaixin on 2019/7/16 10:45
 */
public class Brid {
    //@Value 进行赋值：1，基本字符 2，springEl表达式 3,.properties文件属性
    @Value("James")
    private String name;
    @Value("#{20-3}")
    private Integer age;
    @Value("${brid.color}")
    private String color;


    public Brid() {
        super();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Brid{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
