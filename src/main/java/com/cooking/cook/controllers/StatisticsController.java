package com.cooking.cook.controllers;

import com.cooking.cook.service.StatisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {

    private StatisticsService statisticsService;
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/createRecord")
    public String getStatistics() {
        return "startCollectingStats";
    }
}
