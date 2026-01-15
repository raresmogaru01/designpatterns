package org.example.structural.service;

import org.example.structural.entity.Book;

public class SimpleBookDisplay implements BookDecorator {
    private final Book book;

    public SimpleBookDisplay(Book book) {
        this.book = book;
    }

    @Override
    public String getDescription() {
        return book.getTitle() + " by " + book.getAuthor();
    }

    @Override
    public double getPrice() {
        return book.getPrice();
    }
}