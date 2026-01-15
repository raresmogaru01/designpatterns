
package org.example.handler;

import org.example.Order;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InventoryCheckHandler extends OrderValidationHandler {
    @Override
    public void validate(Order order) {
        // TODO: Check if items are in stock
        if (order.getTotalAmount() <= 0) {
            throw new IllegalStateException("Inventory check failed");
        }

        log.info("Inventory check passed for order {}", order.getId());
        validateNext(order);
    }
}
