package com.cooking.cook.repositories;

import com.cooking.cook.data.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

}
