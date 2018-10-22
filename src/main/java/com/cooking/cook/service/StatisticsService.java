package com.cooking.cook.service;

import com.cooking.cook.repositories.StatisticsRepository;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private StatisticsRepository statisticsRepository;
    private PizzaService pizzaService;
    public StatisticsService(StatisticsRepository statisticsRepository, PizzaService pizzaService) {
        this.statisticsRepository = statisticsRepository;
        this.pizzaService = pizzaService;
    }

    public void increaseNumberOfTotalOrders(Integer amount, Long id) {
        statisticsRepository.updateTotalNumberOfOrders(amount, id);
    }

    private Integer getOldTotalNumberOfOrders(Long id) {
        return statisticsRepository.getPreviousTotalNumberOfOrders(id);
    }

    public void updateTotalNumberOfOrdersWithEditing(Integer oldAmount, Integer currentAmount, String name) {
        if (oldAmount - currentAmount > 0) {
            statisticsRepository.updateTotalNumberOfOrdersByEditingWithPositiveDisparity(getOldTotalNumberOfOrders(pizzaService.getIdByGivenName(name)),
                    oldAmount - currentAmount, pizzaService.getIdByGivenName(name));
        } else {
            statisticsRepository.updateTotalNumberOfOrdersByEditingWithNegativeDisparity(getOldTotalNumberOfOrders(pizzaService.getIdByGivenName(name)),
                    Math.abs(oldAmount - currentAmount), pizzaService.getIdByGivenName(name));
        }
    }
}
