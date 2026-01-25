package org.example.command;

import org.example.Order;
import org.example.payment.PaymentStrategy;
import org.example.service.OrderService;

public class PlaceOrderCommand implements OrderCommand {
    private final OrderService orderService;
    private final Order order;
    private final PaymentStrategy paymentStrategy;

    public PlaceOrderCommand(OrderService orderService, Order order, PaymentStrategy paymentStrategy) {
        this.orderService = orderService;
        this.order = order;
        this.paymentStrategy = paymentStrategy;
    }

    @Override
    public void execute() {
        orderService.processOrder(order, paymentStrategy);
    }
}