package com.maneng.jpa.demo.frank.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author maneng
 * @date created at 2020/3/27 5:44 下午
 */
@Configuration
public class BeanConfig {

    @Bean("aaa")
    public BeanDateSource beanDateSource() {
        return new BeanDateSource();
    }

    @Bean("bbb")
    public BeanDateSource beanDateSource1() {
        return new BeanDateSource();
    }

}
