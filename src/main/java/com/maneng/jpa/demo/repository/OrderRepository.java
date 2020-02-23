package com.maneng.jpa.demo.repository;

import com.maneng.jpa.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by maneng on 2020/02/23.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}




