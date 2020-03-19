package com.maneng.jpa.demo.controller;

import com.maneng.jpa.demo.dto.OrderDTO;
import com.maneng.jpa.demo.foundation.base.result.Result;
import com.maneng.jpa.demo.service.OrderService;
import org.springframework.web.bind.annotation.*;

/**
* Created by maneng on 2020/02/23.
*/
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Result<OrderDTO> saveOrUpdateOrder(OrderDTO orderDTO) {
        return orderService.saveOrUpdateOrder(orderDTO);
    }

    @GetMapping("/{id}")
    public Result<OrderDTO> getOrder(@PathVariable(name = "id") Long id) {
        return orderService.getOrder(id);
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteOrder(@PathVariable(name = "id") Long id) {
        return orderService.deleteOrder(id);
    }
}
