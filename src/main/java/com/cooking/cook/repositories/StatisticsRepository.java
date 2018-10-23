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
    @Transactional
    @Modifying
    @Query("update Statistics s set s.totalNumberOfOrders = s.totalNumberOfOrders - :current where s.id = :id")
    void updateTotalNumberOfOrdersByEditingWithPositiveDisparity(@Param("current") Integer current,
                                                                 @Param("id") Long id);
    @Transactional
    @Modifying
    @Query("update Statistics s set s.totalNumberOfOrders = s.totalNumberOfOrders + :current where s.id = :id")
    void updateTotalNumberOfOrdersByEditingWithNegativeDisparity(@Param("current") Integer current,
                                                                 @Param("id") Long id);
    @Transactional
    @Modifying
    @Query("update Statistics s set s.totalNumberOfOrders = (s.totalNumberOfOrders - :subtractValue) + " +
            "abs(s.totalNumberOfOrders - :subtractValue) where s.id = :id")
    void subtractFromOldAmountValue(@Param("subtractValue") Integer subtractValue, @Param("id") Long id);
}
