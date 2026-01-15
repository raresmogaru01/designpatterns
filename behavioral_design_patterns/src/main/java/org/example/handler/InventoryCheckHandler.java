package org.example.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.Order;

@Slf4j
public class InventoryCheckHandler extends OrderValidationHandler {

    @Override
    public void validate(Order order) {
        if (order.getTotalAmount() <= 0) {
            throw new IllegalStateException("Inventory check failed");
        }

        log.info("Inventory check passed for order {}", order.getId());
        validateNext(order);
    }
}