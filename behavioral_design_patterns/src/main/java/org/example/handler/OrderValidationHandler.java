package org.example.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderValidationHandler extends Handler {
    @Override
    public boolean handle(Order order) {
        if (order.getCustomerName() == null || order.getCustomerName().isEmpty()) {
            log.error("Validation Failed: Missing customer name");
            return false;
        }
        log.info("Step 1: Basic Order Validation Passed");
        return super.handle(order);
    }
}