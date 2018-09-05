package com.cooking.cook.model;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@EnableTransactionManagement
@Table(name = "PIZZA")
public class Pizza {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @NotBlank
    @Column(name = "PRICE")
    private double price;
    @NotBlank
    @Column(name = "DIAMETER")
    private int diameter;
    @NotBlank
    @Column(name = "NAME")
    private String name;

    public Pizza() {
    }

    public Pizza(double price, int diameter, String name, Long id) {
        this.price = price;
        this.diameter = diameter;
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pizza{");
        sb.append("price=").append(price);
        sb.append(", diameter=").append(diameter);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
