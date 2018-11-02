package com.cooking.cook.controllers;

import com.cooking.cook.service.StatisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {

    private StatisticsService statisticsService;
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/statistics")
    public String getStatistics(Model model) {
        model.addAttribute("statList", statisticsService.getAllStatistics());
        model.addAttribute("totalOrdersSum", statisticsService.sumAllTotalOrders());
        model.addAttribute("favouritePizzaAllTime", statisticsService.getFavouritePizzaThroughAllTime());
        return "statisticsView";
    }
}
