package com.maneng.jpa.demo.service.impl;

import com.maneng.jpa.demo.dto.OrderDTO;
import com.maneng.jpa.demo.entity.Order;
import com.maneng.jpa.demo.foundation.base.result.Result;
import com.maneng.jpa.demo.service.OrderService;
import com.maneng.jpa.demo.manager.OrderManager;
import com.maneng.jpa.demo.assembler.OrderAssembler;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by maneng on 2020/02/23.
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderManager orderManager;
    private final OrderAssembler orderAssembler;

    public OrderServiceImpl(OrderManager orderManager, OrderAssembler orderAssembler) {
        this.orderManager = orderManager;
        this.orderAssembler = orderAssembler;
    }


    @Override
    public Result<OrderDTO> saveOrUpdateOrder(OrderDTO orderDTO) {
        Order order = orderAssembler.assemblerOrder(orderDTO);
        return new Result<>(orderAssembler.assemblerOrderDTO(orderManager.saveOrUpdateOrder(order)));
    }

    @Override
    public Result<Void> deleteOrder(Long id) {
        Result<Void> result = new Result<>();
        Order order = orderManager.getOrder(id);
        if (null == order) {
            log.info("entity not exists, order id: {}", id);
        } else {
            orderManager.delete(order);
        }
        return result;
    }

    @Override
    public Result<OrderDTO> getOrder(Long id) {
        Result<OrderDTO> result = new Result<>();
        OrderDTO orderDTO = orderAssembler.assemblerOrderDTO(orderManager.getOrder(id));
        result.setResult(orderDTO);
        return result;
    }
}
