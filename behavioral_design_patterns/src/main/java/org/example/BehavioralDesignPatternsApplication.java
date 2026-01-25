package org.example;

import org.example.command.PlaceOrderCommand;
import org.example.notification.EmailNotification;
import org.example.notification.NotificationService;
import org.example.notification.SMSNotification;
import org.example.payment.CreditCardPayment;
import org.example.payment.PayPalPayment;
import org.example.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BehavioralDesignPatternsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BehavioralDesignPatternsApplication.class, args);
    }

    @Bean
    public CommandLineRunner runDemo(OrderService orderService, NotificationService notificationService) {
        return args -> {
            notificationService.attach(new EmailNotification());
            notificationService.attach(new SMSNotification());

            System.out.println("==========================================");
            Order order1 = new Order();
            order1.setCustomerName("Alice");
            order1.setTotalAmount(100.00);
            order1.setStatus("NEW");

            PlaceOrderCommand command1 = new PlaceOrderCommand(orderService, order1, new CreditCardPayment("1234-5678"));
            command1.execute();


            System.out.println("==========================================");
            Order order2 = new Order();
            order2.setCustomerName("Bob");
            order2.setTotalAmount(50.00);
            order2.setStatus("NEW");

            PlaceOrderCommand command2 = new PlaceOrderCommand(orderService, order2, new PayPalPayment("bob@email.com"));
            command2.execute();
            System.out.println("==========================================");
        };
    }
}