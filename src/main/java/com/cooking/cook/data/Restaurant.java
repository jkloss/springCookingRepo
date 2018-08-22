package com.cooking.cook.data;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Restaurant {

    private List<Pizza> menu = new ArrayList<>();

    public List<Pizza> getMenu() {
        return menu;
    }

    public void setMenu(List<Pizza> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Restaurant{");
        sb.append("menu=").append(menu);
        sb.append('}');
        return sb.toString();
    }
}
