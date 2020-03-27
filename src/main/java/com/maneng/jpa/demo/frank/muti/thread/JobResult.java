package com.maneng.jpa.demo.frank.muti.thread;

import lombok.Data;

import java.io.Serializable;

/**
 * @author maneng
 * @date created at 2020/3/27 4:01 下午
 */
@Data
public class JobResult implements Serializable {

    /**
     * 最小主键id
     */
    private Long minId;

    /**
     * 最大主键id
     */
    private Long maxId;


    /**
     * 多任务的任务名称
     */
    private String jobName;

    /**
     * 任务处理数据数量
     */
    private Integer processCount;

    /**
     * 任务处理成功数量
     */
    private Integer successProcessCount;

}
