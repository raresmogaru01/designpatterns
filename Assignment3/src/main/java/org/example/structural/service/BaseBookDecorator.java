package org.example.structural.service;

public abstract class BaseBookDecorator implements BookDecorator {

    protected final BookDecorator wrapped;

    protected BaseBookDecorator(BookDecorator wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription();
    }

    @Override
    public double getPrice() {
        return wrapped.getPrice();
    }
}