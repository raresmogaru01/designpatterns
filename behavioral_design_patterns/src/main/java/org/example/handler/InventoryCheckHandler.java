package org.example.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InventoryCheckHandler extends Handler {
    @Override
    public boolean handle(Order order) {
        if (order.getTotalAmount() > 10000) {
            log.error("Validation Failed: Order too large for current inventory");
            return false;
        }
        log.info("Step 2: Inventory Check Passed");
        return super.handle(order);
    }
}