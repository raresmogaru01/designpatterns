package org.example.structural.service;

public class BestsellerBookDecorator extends AbstractBookDecorator {
    public BestsellerBookDecorator(BookDecorator decoratedBook) {
        super(decoratedBook);
    }

    @Override
    public String getDescription() {
        return "*** BESTSELLER *** " + super.getDescription();
    }

    @Override
    public double getPrice() {
        return super.getPrice() * 1.2; // Bestsellers are 20% more expensive
    }
}