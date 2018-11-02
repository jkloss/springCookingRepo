package com.cooking.cook.service;

import com.cooking.cook.model.Statistics;
import com.cooking.cook.repositories.StatisticsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void updateTotalNumberOfOrdersWithEditingTheSameName(Integer oldAmount, Integer currentAmount, String name) {
        if (oldAmount - currentAmount > 0) {
            statisticsRepository.updateTotalNumberOfOrdersByEditingWithPositiveDisparity(oldAmount - currentAmount, pizzaService.getIdByGivenName(name));
        } else {
            statisticsRepository.updateTotalNumberOfOrdersByEditingWithNegativeDisparity(
                    Math.abs(oldAmount - currentAmount), pizzaService.getIdByGivenName(name));
        }
    }

    public void subtractOldValueOfAmount(Integer subValue, String name) {
        statisticsRepository.subtractFromOldAmountValue(subValue, pizzaService.getIdByGivenName(name));
    }

    public List<Statistics> getAllStatistics() {
        return statisticsRepository.findAll();
    }
}
