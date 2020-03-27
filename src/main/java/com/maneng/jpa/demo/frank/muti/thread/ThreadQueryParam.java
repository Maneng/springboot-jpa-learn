package com.maneng.jpa.demo.frank.muti.thread;

import lombok.Data;

import java.io.Serializable;

/**
 * @author maneng
 * @date created at 2020/3/27 4:00 下午
 */
@Data
public class ThreadQueryParam implements Serializable {
    /**
     * 最小主键id
     */
    private Long minId;

    /**
     * 最大主键id
     */
    private Long maxId;

}
