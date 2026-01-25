package org.example.payment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        log.info("Paid ${} using PayPal account: {}", amount, email);
    }
}