package com.cooking.cook.controllers;

import com.cooking.cook.model.Statistics;
import com.cooking.cook.service.StatisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/createRecord")
    public String createRecord() {
        statisticsService.createInitialRecord(new Statistics(0, 0));
        return "statisticsStarted";
    }

}
