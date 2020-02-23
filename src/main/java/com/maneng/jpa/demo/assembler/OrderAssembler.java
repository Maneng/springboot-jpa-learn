package com.maneng.jpa.demo.assembler;
import com.maneng.jpa.demo.dto.OrderDTO;
import com.maneng.jpa.demo.entity.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
* Created by maneng on 2020/02/23.
*/
@Component
public class OrderAssembler {

    public OrderDTO assemblerOrderDTO(Order order) {
        if (null == order) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(order, orderDTO);
        return orderDTO;
    }

    public Order assemblerOrder(OrderDTO orderDTO) {
        if (null == orderDTO) {
            return null;
        }

        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        return order;
    }
}

