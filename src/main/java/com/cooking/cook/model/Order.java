package com.cooking.cook.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(max = 256)
    @Pattern(regexp = "^[A-Za-z]+$")
    @NotBlank
    private String pizzaName;
    @Min(value = 1)
    @NotNull
    private Integer amountOfOrders;


    public Order(String pizzaName, Integer amountOfOrders) {
        this.pizzaName = pizzaName;
        this.amountOfOrders = amountOfOrders;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public Integer getAmountOfOrders() {
        return amountOfOrders;
    }

    public void setAmountOfOrders(Integer amountOfOrders) {
        this.amountOfOrders = amountOfOrders;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Order{");
        sb.append("id=").append(id);
        sb.append(", pizzaName='").append(pizzaName).append('\'');
        sb.append(", amountOfOrders=").append(amountOfOrders);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return amountOfOrders == order.amountOfOrders &&
                Objects.equals(id, order.id) &&
                Objects.equals(pizzaName, order.pizzaName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pizzaName, amountOfOrders);
    }
}
