package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.Order;
import org.example.command.PlaceOrderCommand;
import org.example.handler.OrderValidationHandler;
import org.example.notification.NotificationService;
import org.example.payment.PaymentStrategy;
import org.example.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderValidationHandler orderValidationChain;
    private final OrderRepository repository;
    private final NotificationService notificationService;
    private final PaymentStrategy paymentStrategy;

    public Order placeOrder(Order order) {
        orderValidationChain.validate(order);
        paymentStrategy.pay(order.getTotalAmount());

        new PlaceOrderCommand(order, repository, notificationService).execute();
        return order;
    }

    public Order getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }

    public Iterable<Order> getAll() {
        return repository.findAll();
    }
}