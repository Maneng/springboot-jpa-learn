package com.maneng.jpa.demo.frank.muti.thread;

/**
 * @author maneng
 * @date created at 2020/3/27 4:20 下午
 */
public class ThreadTaskTest {

    public static void main(String[] args) {
        Integer threadSize = 10;
        ThreadTask threadTask = new ThreadTask(threadSize);
        threadTask.execute();
    }
}
