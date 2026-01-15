package org.example.command;

import lombok.RequiredArgsConstructor;
import org.example.Order;
import org.example.notification.NotificationService;
import org.example.repository.OrderRepository;

@RequiredArgsConstructor
public class PlaceOrderCommand implements OrderCommand {

    private final Order order;
    private final OrderRepository repository;
    private final NotificationService notificationService;

    @Override
    public void execute() {
        order.updateStatus("PLACED");
        repository.save(order);
        notificationService.notifyObservers("Order placed: " + order.getId());
    }
}