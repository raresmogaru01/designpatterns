
package org.example.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.Order;

@Slf4j
public class PaymentValidationHandler extends OrderValidationHandler {
    @Override
    public void validate(Order order) {
        // TODO: Validate payment details
        if (order.getCustomerName() == null || order.getCustomerName().isBlank()) {
            throw new IllegalStateException("Payment validation failed");
        }

        log.info("Payment validation passed for order {}", order.getId());
        validateNext(order);
    }
}
