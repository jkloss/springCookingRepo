package com.cooking.cook.repositories;

import com.cooking.cook.model.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<PizzaOrder, Long> {
    List<PizzaOrder> findAll();
   // @Modifying
//    @Query(value = "update PizzaOrder o set o.amountOfOrders = o.amountOfOrders + :number " +
//            "where o.pizzaName like :name")
//    PizzaOrder getUpdatedOrder(@Param("number") Integer number, @Param("name") String name);
}
