package com.maneng.jpa.demo.frank.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author maneng
 * @date created at 2020/3/20 4:24 下午
 */
@Component
@Order(2)
public class ServerStartRunner1 implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，第二次执行加载数据等操作<<<<<<<<<<<<<");
    }
}
