package com.cooking.cook.service;

import com.cooking.cook.model.Statistics;
import com.cooking.cook.repositories.StatisticsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalInt;

import static java.util.stream.Collectors.toList;

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

    public Integer sumAllTotalOrders() {
        return statisticsRepository.findAll().stream()
                .mapToInt(Statistics::getTotalNumberOfOrders)
                .sum();
    }

    public String getFavouritePizzaThroughAllTime() {
        OptionalInt max = statisticsRepository.findAll().stream()
                .mapToInt(Statistics::getTotalNumberOfOrders)
                .max();

        if (!max.isPresent()) {
            return "no data";
        }

        List<String> favouritePizzas = statisticsRepository.findAll().stream()
                .filter(s -> s.getTotalNumberOfOrders() == max.getAsInt())
                .map(p -> p.getPizza().getName())
                .collect(toList());

        String result = "";

        for (String s : favouritePizzas) {
            result = result.concat(s + ", ");
        }

        return result.substring(0, result.length() - 2);
    }
}