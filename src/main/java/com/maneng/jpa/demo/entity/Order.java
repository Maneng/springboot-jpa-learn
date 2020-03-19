package com.maneng.jpa.demo.entity;

import com.maneng.jpa.demo.foundation.persistence.LongTimestampedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author maneng
 * @date created at 2020/2/23 5:18 下午
 */
@Data
@Entity
@Table(name = "order_info")
@EqualsAndHashCode(callSuper = true)
public class Order extends LongTimestampedEntity {
    /**
     * 用户名
     */
    private String username;

}
