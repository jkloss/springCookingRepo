package com.cooking.cook.service;

import com.cooking.cook.model.PizzaOrder;
import com.cooking.cook.repositories.OrderRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void makeNewOrder(PizzaOrder pizzaOrder) {
        orderRepository.save(pizzaOrder);
    }

    public void changeAmountOfOrder(String name, Integer numberOfOrders) {
        orderRepository.getUpdatedOrder(numberOfOrders, name);
    }
}
