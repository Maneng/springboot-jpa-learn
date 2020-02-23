package com.maneng.jpa.demo.entity;

import com.maneng.jpa.demo.foundation.persistence.LongTimestampedEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author maneng
 * @date created at 2020/2/23 5:18 下午
 */
@Data
@Entity
@Table(name = "order")
public class Order extends LongTimestampedEntity {

}
