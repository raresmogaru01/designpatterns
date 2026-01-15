package org.example.payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("creditCardPayment")
@Slf4j
public class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        log.info("Paid ${} using credit card ", amount);
    }