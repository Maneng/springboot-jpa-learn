package com.maneng.jpa.demo.config.enable;

/**
 * @author maneng
 * @date created at 2020/3/25 7:36 下午
 */
public class FtpServer implements Server {
    @Override
    public void run() {
        System.out.println("ftp server start...");
    }

    @Override
    public void stop() {
        System.out.println("ftp server stop...");
    }
}
