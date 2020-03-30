package com.maneng.jpa.demo.frank.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author maneng
 * @date created at 2020/3/27 5:47 下午
 */
@Component
public class BeanComponent {

    @Autowired
    @Qualifier("aaa")
    private BeanDateSource beanDateSource;

    public BeanComponent() {
    }
}
