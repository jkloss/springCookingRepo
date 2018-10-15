package com.cooking.cook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer totalNumberOfOrders;
    private Integer ordersInPeriodOfTime;
    private Integer favouritePizza;

    public Statistics(Integer totalNumberOfOrders, Integer ordersInPeriodOfTime, Integer favouritePizza) {
        this.totalNumberOfOrders = totalNumberOfOrders;
        this.ordersInPeriodOfTime = ordersInPeriodOfTime;
        this.favouritePizza = favouritePizza;
    }

    public Statistics() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotalNumberOfOrders() {
        return totalNumberOfOrders;
    }

    public void setTotalNumberOfOrders(Integer totalNumberOfOrders) {
        this.totalNumberOfOrders = totalNumberOfOrders;
    }

    public Integer getOrdersInPeriodOfTime() {
        return ordersInPeriodOfTime;
    }

    public void setOrdersInPeriodOfTime(Integer ordersInPeriodOfTime) {
        this.ordersInPeriodOfTime = ordersInPeriodOfTime;
    }

    public Integer getFavouritePizza() {
        return favouritePizza;
    }

    public void setFavouritePizza(Integer favouritePizza) {
        this.favouritePizza = favouritePizza;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Statistics{");
        sb.append("id=").append(id);
        sb.append(", totalNumberOfOrders=").append(totalNumberOfOrders);
        sb.append(", ordersInPeriodOfTime=").append(ordersInPeriodOfTime);
        sb.append(", favouritePizza=").append(favouritePizza);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Statistics)) return false;
        Statistics that = (Statistics) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(totalNumberOfOrders, that.totalNumberOfOrders) &&
                Objects.equals(ordersInPeriodOfTime, that.ordersInPeriodOfTime) &&
                Objects.equals(favouritePizza, that.favouritePizza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalNumberOfOrders, ordersInPeriodOfTime, favouritePizza);
    }
}
