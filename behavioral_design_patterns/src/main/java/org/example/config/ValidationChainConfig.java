package org.example.config;

import org.example.handler.InventoryCheckHandler;
import org.example.handler.OrderValidationHandler;
import org.example.handler.PaymentValidationHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationChainConfig {

    @Bean
    public OrderValidationHandler orderValidationChain() {
        InventoryCheckHandler inventory = new InventoryCheckHandler();
        PaymentValidationHandler payment = new PaymentValidationHandler();

        inventory.setNext(payment);
        return inventory;
    }
}