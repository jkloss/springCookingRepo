package com.cooking.cook.service;

import com.cooking.cook.model.PizzaOrder;
import com.cooking.cook.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
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

    public List<PizzaOrder> getSortedPizzaOrderList() {
        return orderRepository.findAll().stream()
                .sorted(Comparator.comparing(PizzaOrder::getOrderName))
                .collect(toList());
    }

    public boolean checkIfOrderExists(String name) {
        return orderRepository.findAll().stream()
                .anyMatch(o -> o.getOrderName().equals(name));
    }

    public List<PizzaOrder> findAll() {
        return orderRepository.findAll();
    }

    public void deleteRecordFromOrderTable(Long id) {
        orderRepository.deleteRecordInOrderTable(id);
    }

    public List<PizzaOrder> getOrderListByCreatedBy(Optional<String> createdBy) {
        return orderRepository.findAllByOrderCreatedBy(createdBy);
    }
}
