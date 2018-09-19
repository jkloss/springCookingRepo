package com.cooking.cook.repositories;

import com.cooking.cook.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findAll();
    Pizza findAllByNameEquals(String name);
    @Query("SELECT AVG(p.price) FROM Pizza p")
    double getPizzaPriceAvg();
    @Query("select sum(p.price) from Pizza p")
    double getPizzaPriceSum();
    List<Pizza> findByNameStartingWith(String beginning);
}
