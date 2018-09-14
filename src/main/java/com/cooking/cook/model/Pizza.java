package com.cooking.cook.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Pizza {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Range(max = 150)
    private Double price;
    @NotNull
    @Min(value = 10)
    private Integer diameter;
    @NotBlank
    @Length(max = 256)
    private String name;
    @CreatedBy
    private String createdBy;

    public Pizza() {
    }

    public Pizza(Double price, Integer diameter, String name, Long id) {
        this.price = price;
        this.diameter = diameter;
        this.name = name;
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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
        sb.append("id=").append(id);
        sb.append(", price=").append(price);
        sb.append(", diameter=").append(diameter);
        sb.append(", name='").append(name).append('\'');
        sb.append(", createdBy='").append(createdBy).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
