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

    private Integer getOldTotalNumberOfOrders() {
        return statisticsRepository.getPreviousTotalNumberOfOrders();
    }

    public void updateTotalNumberOfOrdersWithEditing(Integer oldAmount, Integer currentAmount) {
        if (oldAmount - currentAmount > 0) {
            statisticsRepository.updateTotalNumberOfOrdersByEditingWithPositiveDisparity(getOldTotalNumberOfOrders(),
                    oldAmount - currentAmount);
        } else {
            statisticsRepository.updateTotalNumberOfOrdersByEditingWithNegativeDisparity(getOldTotalNumberOfOrders(),
                    Math.abs(oldAmount - currentAmount));
        }
    }
}
