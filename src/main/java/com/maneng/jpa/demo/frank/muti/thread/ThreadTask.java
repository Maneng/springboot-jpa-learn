package com.maneng.jpa.demo.frank.muti.thread;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author maneng
 * @date created at 2020/3/27 4:10 下午
 */
public class ThreadTask {

    Integer threadSize;

    public ThreadTask(Integer threadSize) {
        this.threadSize = threadSize;
    }

    public void execute() {
        Stopwatch stopwatch = Stopwatch.createStarted();

        ExecutorService executorService = Executors.newFixedThreadPool(threadSize);

        List<Callable<JobResult>> jobList = Lists.newArrayList();

        for (Integer i = 0; i < threadSize; i++) {
            JobParam jobParam = initJobParam(i);
            ThreadJob threadJob = new ThreadJob(jobParam);
            jobList.add(threadJob);
        }

        try {

            List<Future<JobResult>> futures = executorService.invokeAll(jobList);

            for (Future<JobResult> future : futures) {
                if (!future.isDone() || future.isCancelled()) {
                    System.out.println("thread not has done");
                    continue;
                }
                JobResult jobResult = future.get();
                System.out.println(jobResult.toString());
            }
            stopwatch.stop();
            long seconds = stopwatch.elapsed().getSeconds();
            System.out.println("process thread cost time: " + seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private JobParam initJobParam(Integer i) {
        JobParam jobParam = new JobParam();
        jobParam.setMinId((long) i);
        jobParam.setMaxId((long) (i * 10 - 1));
        jobParam.setThreadQueryParam(new ThreadQueryParam());
        return jobParam;
    }
}
