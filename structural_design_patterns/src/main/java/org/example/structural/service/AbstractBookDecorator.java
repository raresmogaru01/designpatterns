package org.example.structural.service;

public abstract class AbstractBookDecorator implements BookDecorator {
    protected BookDecorator decoratedBook;

    public AbstractBookDecorator(BookDecorator decoratedBook) {
        this.decoratedBook = decoratedBook;
    }

    @Override
    public String getDescription() {
        return decoratedBook.getDescription();
    }

    @Override
    public double getPrice() {
        return decoratedBook.getPrice();
    }
}