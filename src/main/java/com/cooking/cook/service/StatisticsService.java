package com.cooking.cook.service;

import com.cooking.cook.model.Statistics;
import com.cooking.cook.repositories.StatisticsRepository;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private StatisticsRepository statisticsRepository;
    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    public void increaseNumberOfTotalOrders(Integer amount) {
        statisticsRepository.updateTotalNumberOfOrders(amount);
    }

    public void createInitialRecord(Statistics statistics) {
        statisticsRepository.save(statistics);
    }
}
