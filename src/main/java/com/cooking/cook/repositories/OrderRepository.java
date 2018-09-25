package com.cooking.cook.repositories;

import com.cooking.cook.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAll();
   // @Modifying
//    @Query(value = "update Order o set o.amountOfOrders = o.amountOfOrders + :number " +
//            "where o.pizzaName like :name")
//    Order getUpdatedOrder(@Param("number") Integer number, @Param("name") String name);
}
