package com.cooking.cook.controllers;

import com.cooking.cook.model.Order;
import com.cooking.cook.service.OrderService;
import com.cooking.cook.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    private OrderService orderService;
    private PizzaService pizzaService;
    public OrderController(OrderService orderService, PizzaService pizzaService) {
        this.orderService = orderService;
        this.pizzaService = pizzaService;
    }

    @GetMapping("/order")
    public String getPizzaListToChoose(Model model, @ModelAttribute(value = "order") Order order) {
        model.addAttribute("pizzaList", pizzaService.getPizzaList());
        return "orderHome";
    }

    @PostMapping("/order")
    public String submitOrder(Model model, @ModelAttribute(value = "order") Order order) {
        model.addAttribute("pizzaName", order.getPizzaName());
        model.addAttribute("amount", order.getAmountOfOrders());
        orderService.makeNewOrder(order);
       // orderService.changeAmountOfOrder(order.getPizzaName(), order.getAmountOfOrders());
        return "orderConfirmView";
    }
}
