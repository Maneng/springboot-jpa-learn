package com.maneng.jpa.demo.frank.muti.thread;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author maneng
 * @date created at 2020/3/27 3:54 下午
 */
@Data
@ToString
public class JobParam implements Serializable {


    /**
     * 最小主键id
     */
    private Long minId;

    /**
     * 最大主键id
     */
    private Long maxId;

    private ThreadQueryParam threadQueryParam;
}
