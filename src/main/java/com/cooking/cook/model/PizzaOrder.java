package com.cooking.cook.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class PizzaOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(max = 256)
    @Pattern(regexp = "^[A-Za-z]+$")
    @NotBlank
    private String orderName;
    @Min(value = 1)
    @NotNull
    private Integer amount;
    @CreatedBy
    private String orderCreatedBy;

    public PizzaOrder(String orderName, Integer amount, String orderCreatedBy) {
        this.orderName = orderName;
        this.amount = amount;
        this.orderCreatedBy = orderCreatedBy;
    }

    public PizzaOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getOrderCreatedBy() {
        return orderCreatedBy;
    }

    public void setOrderCreatedBy(String orderCreatedBy) {
        this.orderCreatedBy = orderCreatedBy;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PizzaOrder{");
        sb.append("id=").append(id);
        sb.append(", orderName='").append(orderName).append('\'');
        sb.append(", amount=").append(amount);
        sb.append(", orderCreatedBy='").append(orderCreatedBy).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PizzaOrder)) return false;
        PizzaOrder that = (PizzaOrder) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(orderName, that.orderName) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(orderCreatedBy, that.orderCreatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderName, amount, orderCreatedBy);
    }
}
