package org.example.config;

import org.example.handler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationChainConfig {

    @Bean("validationChain")
    public Handler validationChain(
            OrderValidationHandler orderValidation,
            InventoryCheckHandler inventoryCheck,
            PaymentValidationHandler paymentValidation) {

        //chain: OrderValidation -> InventoryCheck ->PaymentValidation
        orderValidation.setNext(inventoryCheck);
        inventoryCheck.setNext(paymentValidation);

        return orderValidation;
    }
}