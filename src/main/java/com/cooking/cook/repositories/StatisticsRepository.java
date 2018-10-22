package com.cooking.cook.repositories;

import com.cooking.cook.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
    @Transactional
    @Modifying
    @Query("update Statistics s set s.totalNumberOfOrders = s.totalNumberOfOrders + :amount where s.id = :id")
    void updateTotalNumberOfOrders(@Param("amount") Integer amount, @Param("id") Long id);
    @Query("select s.totalNumberOfOrders from Statistics s where s.id = :idOfPizza")
    Integer getPreviousTotalNumberOfOrders(@Param("idOfPizza") Long name);
    @Transactional
    @Modifying
    @Query("update Statistics s set s.totalNumberOfOrders = :previous - :current where s.id = :id")
    void updateTotalNumberOfOrdersByEditingWithPositiveDisparity(@Param("previous") Integer previous,
                                                                 @Param("current") Integer current,
                                                                 @Param("id") Long id);
    @Transactional
    @Modifying
    @Query("update Statistics s set s.totalNumberOfOrders = :previous + :current where s.id = :id")
    void updateTotalNumberOfOrdersByEditingWithNegativeDisparity(@Param("previous") Integer previous,
                                                                 @Param("current") Integer current,
                                                                 @Param("id") Long id);
}
