package org.example.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentValidationHandler extends Handler {
    @Override
    public boolean handle(Order order) {
        if (order.getTotalAmount() <= 0) {
            log.error("Validation Failed: Invalid total amount");
            return false;
        }
        log.info("Step 3: Payment Validation Passed");
        return super.handle(order);
    }
}