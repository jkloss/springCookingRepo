package com.cooking.cook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Integer totalNumberOfOrders;
    @NotNull
    private Integer ordersInMonth;
    @OneToOne(mappedBy = "statistics")
    @JsonBackReference
    private Pizza pizza;

    public Statistics(Integer totalNumberOfOrders, Integer ordersInMonth) {
        this.totalNumberOfOrders = totalNumberOfOrders;
        this.ordersInMonth = ordersInMonth;
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

    public Integer getOrdersInMonth() {
        return ordersInMonth;
    }

    public void setOrdersInMonth(Integer ordersInMonth) {
        this.ordersInMonth = ordersInMonth;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Statistics{");
        sb.append("id=").append(id);
        sb.append(", totalNumberOfOrders=").append(totalNumberOfOrders);
        sb.append(", ordersInMonth=").append(ordersInMonth);
        sb.append(", pizza=").append(pizza);
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
                Objects.equals(ordersInMonth, that.ordersInMonth) &&
                Objects.equals(pizza, that.pizza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalNumberOfOrders, ordersInMonth, pizza);
    }
}
