package com.cooking.cook.controllers;

import com.cooking.cook.service.OrderService;
import com.cooking.cook.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    private OrderService orderService;
    private PizzaService pizzaService;
    public OrderController(OrderService orderService, PizzaService pizzaService) {
        this.orderService = orderService;
        this.pizzaService = pizzaService;
    }

    @GetMapping("/order")
    public String getPizzaListToChoose(Model model) {
        model.addAttribute("pizzaList", pizzaService.getPizzaList());
        return "orderHome";
    }
}
