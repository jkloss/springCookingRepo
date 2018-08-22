package com.cooking.cook.data;

import org.springframework.stereotype.Component;

import java.util.List;


public class Restaurant {

    private List<Pizza> menu;
    private boolean isRestaurantOpen;
    private String nameOfRestaurant;

    public List<Pizza> getMenu() {
        return menu;
    }

    public void setMenu(List<Pizza> menu) {
        this.menu = menu;
    }

    public boolean isRestaurantOpen() {
        return isRestaurantOpen;
    }

    public void setRestaurantOpen(boolean restaurantOpen) {
        isRestaurantOpen = restaurantOpen;
    }

    public String getNameOfRestaurant() {
        return nameOfRestaurant;
    }

    public void setNameOfRestaurant(String nameOfRestaurant) {
        this.nameOfRestaurant = nameOfRestaurant;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Restaurant{");
        sb.append("menu=").append(menu);
        sb.append(", isRestaurantOpen=").append(isRestaurantOpen);
        sb.append(", nameOfRestaurant='").append(nameOfRestaurant).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
