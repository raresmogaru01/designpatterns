package org.example.structural.service;

public class FeaturedBookDecorator extends BaseBookDecorator {

    public FeaturedBookDecorator(BookDecorator wrapped) {
        super(wrapped);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " [Featured]";
    }
}
