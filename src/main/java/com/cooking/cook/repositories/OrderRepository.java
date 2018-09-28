package com.cooking.cook.repositories;

import com.cooking.cook.model.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderRepository extends JpaRepository<PizzaOrder, Long> {
    List<PizzaOrder> findAll();
    @Transactional
    @Modifying
    @Query("update PizzaOrder p set p.amount = :number where p.orderName = :name")
    void getUpdatedOrder(@Param("number") Integer number, @Param("name") String name);
    @Transactional
    @Modifying
    @Query("delete from PizzaOrder p where p.id = :id")
    void deleteRecordInORderTable(@Param("id") Long id);
}
