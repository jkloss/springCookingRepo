package com.cooking.cook.controllers;

import com.cooking.cook.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class StatisticsController {

    private OrderService orderService;
    public StatisticsController(OrderService orderService) {
        this.orderService = orderService;
    }

    public String getStatistics(Model model) {
        model.addAttribute("totalNumberOf");

        return "statisticsView";
    }

}
