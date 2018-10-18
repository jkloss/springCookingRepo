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
    @Query("update Statistics s set s.totalNumberOfOrders = s.totalNumberOfOrders + :amount where s.id = 1")
    void updateTotalNumberOfOrders(@Param("amount") Integer amount);
    @Query("select s.totalNumberOfOrders from Statistics s")
    Integer getPreviousTotalNumberOfOrders();
    @Transactional
    @Modifying
    @Query("update Statistics s set s.totalNumberOfOrders = :previous - :current")
    void updateTotalNumberOfOrdersByEditingWithPositiveDisparity(@Param("previous") Integer previous,
                                                                 @Param("current") Integer current);
    @Transactional
    @Modifying
    @Query("update Statistics s set s.totalNumberOfOrders = :previous + :current")
    void updateTotalNumberOfOrdersByEditingWithNegativeDisparity(@Param("previous") Integer previous,
                                                                 @Param("current") Integer current);
}
