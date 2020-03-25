package com.maneng.jpa.demo.config.enable;

/**
 * @author maneng
 * @date created at 2020/3/25 7:35 下午
 */
public class HttpServer implements Server {
    @Override
    public void run() {
        System.out.println("http server start...");
    }

    @Override
    public void stop() {
        System.out.println("http server stop...");
    }
}
