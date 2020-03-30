package com.maneng.jpa.demo.frank.service;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author maneng
 * @date created at 2020/3/30 11:14 上午
 */
@Service
public class MyService {


    private ConversionService conversionService;

    public MyService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }
}
