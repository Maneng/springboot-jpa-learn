package com.maneng.jpa.demo.entity;

import com.maneng.jpa.demo.foundation.persistence.LongTimestampedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author maneng
 * @date created at 2020/2/23 3:18 下午
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class User extends LongTimestampedEntity {

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
