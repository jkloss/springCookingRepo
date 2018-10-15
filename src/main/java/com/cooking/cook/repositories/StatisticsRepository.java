package com.cooking.cook.repositories;

import com.cooking.cook.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
    @Transactional
    @Modifying
    @Query("update Statistics s set s.totalNumberOfOrders = s.totalNumberOfOrders + 1 where s.id = 1")
    void updateTotalNumberOfOrders();
}
