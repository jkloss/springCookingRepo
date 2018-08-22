package com.cooking.cook.data;

import org.springframework.stereotype.Component;


public class Pizza {
    private double price;
    private int diameter;
    private String name;
    private boolean isPizzaAvailable;

    public Pizza(double price, int diameter, String name, boolean isPizzaAvailable) {
        this.price = price;
        this.diameter = diameter;
        this.name = name;
        this.isPizzaAvailable = isPizzaAvailable;
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

    public boolean isPizzaAvailable() {
        return isPizzaAvailable;
    }

    public void setPizzaAvailable(boolean pizzaAvailable) {
        isPizzaAvailable = pizzaAvailable;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pizza{");
        sb.append("price=").append(price);
        sb.append(", diameter=").append(diameter);
        sb.append(", name='").append(name).append('\'');
        sb.append(", isPizzaAvailable=").append(isPizzaAvailable);
        sb.append('}');
        return sb.toString();
    }
}
