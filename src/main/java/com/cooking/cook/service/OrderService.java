package com.cooking.cook.service;

import com.cooking.cook.model.PizzaOrder;
import com.cooking.cook.repositories.OrderRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

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

    public boolean checkIfOrderExistsForLoggedUser(String name, User user) {
        return orderRepository.findAll().stream()
                .filter(o -> o.getOrderName().equals(name) && o.getOrderCreatedBy().equals(user.getUsername()))
                .anyMatch(p -> p.getOrderName().equals(name));
    }

    public List<PizzaOrder> findAll() {
        return orderRepository.findAll();
    }

    public void deleteRecordFromOrderTable(Long id) {
        orderRepository.deleteRecordInOrderTable(id);
    }

    public List<PizzaOrder> getOrderListByCreatedBy(User user) {
        return orderRepository.findAll().stream()
                .filter(o -> o.getOrderCreatedBy().equals(user.getUsername()))
                .collect(toList());
    }
}
