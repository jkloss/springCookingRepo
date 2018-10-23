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
    @Query("update PizzaOrder p set p.amount = :number where p.orderName = :name and p.orderCreatedBy = :user")
    void getUpdatedOrder(@Param("number") Integer number, @Param("name") String name, @Param("user") String user);
    @Transactional
    @Modifying
    @Query("delete from PizzaOrder p where p.id = :id")
    void deleteRecordInOrderTable(@Param("id") Long id);
    @Transactional
    @Modifying
    @Query("update PizzaOrder p set p.orderName = :newName, p.amount = :newAmount where " +
            "p.orderCreatedBy = :creator and p.id = :id")
    void editPizzaOrderWithoutPrice(@Param("newName") String newName, @Param("newAmount") Integer newAmount,
                                    @Param("creator") String creator, @Param("id") Long id);
    @Transactional
    @Modifying
    @Query("update PizzaOrder p set p.pizzaPrice = :newPrice where p.orderName = :name and " +
            "p.orderCreatedBy = :creator")
    void updatePriceInOrders(@Param("name") String name, @Param("newPrice") Double newPrice,
                             @Param("creator") String creator);
    @Query("select p.orderName from PizzaOrder p where p.id = :id")
    String getOrderNameById(@Param("id") Long id);
    @Transactional
    @Modifying
    @Query("update PizzaOrder p set p.amount = :newAmount where p.id = :id")
    void updateAmountOnly(@Param("newAmount") Integer newAmount, @Param("id") Long id);
    @Query("select p.amount from PizzaOrder p where p.orderName = :name and p.orderCreatedBy = :creator")
    Integer getNotEditedAmountOfOrder(@Param("name") String name, @Param("creator") String creator);
}
