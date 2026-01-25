package org.example.payment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        log.info("Paid ${} with Credit Card ending in {}", amount, cardNumber.substring(cardNumber.length() - 4));
    }
}