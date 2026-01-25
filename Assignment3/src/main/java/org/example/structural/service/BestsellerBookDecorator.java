package org.example.structural.service;

public class BestsellerBookDecorator extends BaseBookDecorator {

    public BestsellerBookDecorator(BookDecorator wrapped) {
        super(wrapped);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " [Bestseller]";
    }
}
