package com.cooking.cook.repositories;

import com.cooking.cook.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findAll();
    Pizza findAllByNameEquals(String name);
}
