package com.cooking.cook.model;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;

@Entity
@EnableTransactionManagement
@Table(name = "PIZZA")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "DIAMETER")
    private Integer diameter;
    @Column(name = "NAME")
    private String name;

    public Pizza() {
    }

    public Pizza(Double price, Integer diameter, String name, Long id) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
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
