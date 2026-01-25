package org.example.controller;

import org.example.Order;
import org.example.command.PlaceOrderCommand;
import org.example.payment.CreditCardPayment;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public String placeOrder(@RequestBody Order order) {

        PlaceOrderCommand command = new PlaceOrderCommand(
                orderService,
                order,
                new CreditCardPayment("1234-5678-9012-3456")
        );

        command.execute();
        return "Order processing initiated!";
    }
}