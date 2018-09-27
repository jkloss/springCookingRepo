package com.cooking.cook.controllers;

import com.cooking.cook.model.PizzaOrder;
import com.cooking.cook.service.OrderService;
import com.cooking.cook.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

    private OrderService orderService;
    private PizzaService pizzaService;
    public OrderController(OrderService orderService, PizzaService pizzaService) {
        this.orderService = orderService;
        this.pizzaService = pizzaService;
    }

    @GetMapping("/order")
    public String getPizzaListToChoose(Model model, @ModelAttribute(value = "pizzaOrder") PizzaOrder pizzaOrder) {
        model.addAttribute("pizzaList", pizzaService.getPizzaList());
        return "orderHome";
    }

    @GetMapping("/orderPizza")
    public ModelAndView getOrderPizzaView() {
        return new ModelAndView("choosePizzaView", "pizzaOrderConfirm", new PizzaOrder());
    }

    @PostMapping("/orderPizza")
    public String submitOrder(Model model, @ModelAttribute(value = "pizzaOrderConfirm") PizzaOrder pizzaOrder) {
        model.addAttribute("pizzaName", pizzaOrder.getOrderName());
        model.addAttribute("amount", pizzaOrder.getAmount());
        orderService.makeNewOrder(pizzaOrder);
       // orderService.changeAmountOfOrder(pizzaOrder.getOrderName(), pizzaOrder.getAmount());
        return "orderConfirmView";
    }
}
