package com.maneng.jpa.demo.dto;

import lombok.Data;

/**
 * @author maneng
 * @date created at 2020/2/23 3:37 下午
 */
@Data
public class UserDTO {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long updateTime;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String pass;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 简介
     */
    private String intro;
}
