package com.cooking.cook.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Max(value = 150)
    private Double price;
    @NotNull
    @Min(value = 10)
    private Integer diameter;
    @NotBlank
    @Length(max = 256)
    @Pattern(regexp = "^[A-Za-z]+$")
    private String name;
    @CreatedBy
    private String createdBy;
    @CreatedDate
    private LocalDateTime creationDate;

    public Pizza() {
    }

    public Pizza(Double price, Integer diameter, String name, Long id, LocalDateTime creationDate) {
        this.price = price;
        this.diameter = diameter;
        this.name = name;
        this.id = id;
        this.creationDate = creationDate;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pizza{");
        sb.append("id=").append(id);
        sb.append(", price=").append(price);
        sb.append(", diameter=").append(diameter);
        sb.append(", name='").append(name).append('\'');
        sb.append(", createdBy='").append(createdBy).append('\'');
        sb.append(", creationDate=").append(creationDate);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pizza)) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(id, pizza.id) &&
                Objects.equals(price, pizza.price) &&
                Objects.equals(diameter, pizza.diameter) &&
                Objects.equals(name, pizza.name) &&
                Objects.equals(createdBy, pizza.createdBy) &&
                Objects.equals(creationDate, pizza.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, diameter, name, createdBy, creationDate);
    }
}
