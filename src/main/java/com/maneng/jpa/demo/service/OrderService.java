package com.maneng.jpa.demo.service;

import com.maneng.jpa.demo.dto.OrderDTO;
import com.maneng.jpa.demo.foundation.base.result.Result;

/**
 * Created by maneng on 2020/02/23.
 */
public interface OrderService{

    Result<OrderDTO> saveOrUpdateOrder(OrderDTO orderDTO);

    Result<Void> deleteOrder(Long id);

    Result<OrderDTO> getOrder(Long id);
}