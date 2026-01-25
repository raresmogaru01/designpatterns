package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.Order;
import org.example.handler.Handler;
import org.example.notification.NotificationService;
import org.example.payment.PaymentStrategy;
import org.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final NotificationService notificationService;
    private final Handler validationChain;

    @Autowired
    public OrderService(OrderRepository orderRepository,
                        NotificationService notificationService,
                        @Qualifier("validationChain") Handler validationChain) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
        this.validationChain = validationChain;
    }

    public void processOrder(Order order, PaymentStrategy paymentStrategy) {
        log.info("--- Processing Order for {} ---", order.getCustomerName());

        if (!validationChain.handle(order)) {
            log.error("Order processing aborted due to validation failure.");
            return;
        }

        paymentStrategy.pay(order.getTotalAmount());
        order.setStatus("PAID");
        orderRepository.save(order);

        notificationService.notifyObservers("Order " + order.getId() + " processed successfully!");
    }
}