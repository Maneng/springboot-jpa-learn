package com.maneng.jpa.demo.manager;
import com.maneng.jpa.demo.entity.Order;
import com.maneng.jpa.demo.repository.OrderRepository;
import org.springframework.stereotype.Component;

/**
* Created by maneng on 2020/02/23.
*/
@Component
public class OrderManager {

    private final OrderRepository orderRepository;

    public OrderManager(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrUpdateOrder(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    public Order getOrder(Long id) {
        return orderRepository.getOne(id);
    }

    public void delete(Order order) {
        orderRepository.delete(order);
    }
}

