package com.cooking.cook.service;

import com.cooking.cook.repositories.StatisticsRepository;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private StatisticsRepository statisticsRepository;
    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    public void increaseNumberOfTotalOrders(Integer amount, Long id) {
        statisticsRepository.updateTotalNumberOfOrders(amount, id);
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
