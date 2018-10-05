package com.cooking.cook.controllers;

import com.cooking.cook.exceptions.MultiplyOrderException;
import com.cooking.cook.exceptions.NoPizzaInDatabaseException;
import com.cooking.cook.model.PizzaOrder;
import com.cooking.cook.service.OrderService;
import com.cooking.cook.service.PizzaService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

    private OrderService orderService;
    private PizzaService pizzaService;

    public OrderController(OrderService orderService, PizzaService pizzaService) {
        this.orderService = orderService;
        this.pizzaService = pizzaService;
    }

    @GetMapping("/order")
    public String getPizzaListToChoose(Model model) {
        model.addAttribute("pizzaList", pizzaService.getPizzaList());
        return "orderHome";
    }

    @GetMapping("/orderPizza")
    public ModelAndView getOrderPizzaView() {
        return new ModelAndView("choosePizzaView", "pizzaOrderConfirm", new PizzaOrder());
    }

    @PostMapping("/orderPizza")
    public String submitOrder(Model model, @ModelAttribute(value = "pizzaOrderConfirm") PizzaOrder pizzaOrder,
                              @AuthenticationPrincipal User user) {
        model.addAttribute("pizzaName", pizzaOrder.getOrderName());
        model.addAttribute("amount", pizzaOrder.getAmount());

        if (pizzaService.checkIfPizzaExists(pizzaOrder.getOrderName())) {
            if (!orderService.checkIfOrderExistsForLoggedUser(pizzaOrder.getOrderName(), user)) {

                pizzaOrder.setPizzaPrice(pizzaService.getPizzaPrice(pizzaOrder.getOrderName()));
                orderService.makeNewOrder(pizzaOrder);
                orderService.changeAmountOfOrder(pizzaOrder.getOrderName(), pizzaOrder.getAmount());

            } else {
                throw new MultiplyOrderException();
            }
        } else {
            throw new NoPizzaInDatabaseException();
        }

        return "orderConfirmView";
    }

    @GetMapping("/allOrdersPersonalized")
    public String getAllOrdersView(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("personCreatingOrder", orderService.getOrderListByCreatedBy(user));
        model.addAttribute("totalPrice", orderService.getTotalPrice(user.getUsername()));
        return "allOrdersPersonalizedView";
    }

    @GetMapping("/allOrdersToDisplay")
    public String getAllOrdersToDisplay(Model model) {
        model.addAttribute("allOrderedPizza", orderService.getSortedPizzaOrderList());
        return "allOrdersView";
    }

    @GetMapping("/deleteDoneOrder")
    public String getDeleteView(Model model) {
        model.addAttribute("pizzaOrders", orderService.findAll());
        return "deleteOrderView";
    }

    @DeleteMapping("/deleteRecord/{id}")
    public String deleteRecord(@PathVariable("id") Long id) {
        orderService.deleteRecordFromOrderTable(id);
        return "deleteConfirm";
    }

    @GetMapping("/update")
    public String getUpdateView(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("ordersToUpdate", orderService.getOrderListByCreatedBy(user));
        return "updateView";
    }

    @GetMapping("/doUpdate")
    public String getNewCredentialView(@RequestParam Long id, Model model) {
        model.addAttribute("id", id);
        return "updateChosenOrder";
    }

    @PutMapping("/doUpdate")
    public String updatePizzaOrder(@RequestParam(value = "editedName") String name,
                                   @RequestParam(value = "amount") Integer amount,
                                   @RequestParam Long id, @AuthenticationPrincipal User user) {
        if (pizzaService.checkIfPizzaExists(name)) {
            orderService.editOrder(name, amount, user.getUsername(), id);
            
        } else {
            throw new NoPizzaInDatabaseException();
        }
        return "updateConfirm";
    }
}