package org.example.handler;

import lombok.Setter;
import org.example.Order;

@Setter
public abstract class Handler {
    protected Handler next;

    public boolean handle(Order order) {
        if (next != null) {
            return next.handle(order);
        }
        return true; // End of chain, success
    }
}