package com.maneng.jpa.demo.frank.muti.thread;

import java.util.concurrent.Callable;

/**
 * @author maneng
 * @date created at 2020/3/27 4:02 下午
 */
public class ThreadJob implements Callable<JobResult> {

    /**
     * 最小主键id
     */
    private Long minId;

    /**
     * 最大主键id
     */
    private Long maxId;

    private ThreadQueryParam threadQueryParam;

    public ThreadJob(JobParam param) {
        this.minId = param.getMinId();
        this.maxId = param.getMaxId();
        this.threadQueryParam = param.getThreadQueryParam();
    }

    @Override
    public JobResult call() throws Exception {
        JobResult jobResult = new JobResult();
        String name = Thread.currentThread().getName();
        jobResult.setJobName(name);
        jobResult.setMinId(this.minId);
        jobResult.setMaxId(this.maxId);
        //当前任务处理的数据量
        int processCount = 0;
        //处理成功的数据量
        int totalSuccessProcessCount = 0;

        for (long i = minId; i <= maxId; i++) {
            System.out.println("线程: " + name + ", 正在处理第 " + i + " 条数据");
        }
        Long maxId = threadQueryParam.getMaxId();

        jobResult.setProcessCount(processCount);
        jobResult.setSuccessProcessCount(totalSuccessProcessCount);
        System.out.println("线程: " + name + "处理完成");
        return jobResult;
    }
}
