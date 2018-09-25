package com.cooking.cook.service;

import com.cooking.cook.model.Order;
import com.cooking.cook.repositories.OrderRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void makeNewOrder(Order order) {
        orderRepository.save(order);
    }
}
