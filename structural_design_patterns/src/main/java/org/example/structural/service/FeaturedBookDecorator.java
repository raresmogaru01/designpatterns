package org.example.structural.service;

public class FeaturedBookDecorator extends AbstractBookDecorator {
    public FeaturedBookDecorator(BookDecorator decoratedBook) {
        super(decoratedBook);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " [FEATURED]";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 5.0; // Featured books cost 5.0 more
    }
}