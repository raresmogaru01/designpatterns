package org.example.structural.service;

import java.util.ArrayList;
import java.util.List;

public class BookBundle implements BookDecorator {
    private List<BookDecorator> items = new ArrayList<>();
    private String bundleName;

    public BookBundle(String bundleName) {
        this.bundleName = bundleName;
    }

    public void addItem(BookDecorator item) {
        items.add(item);
    }

    public void removeItem(BookDecorator item) {
        items.remove(item);
    }

    @Override
    public String getDescription() {
        // The description is the bundle name plus the description of all items inside
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle: ").append(bundleName).append(" Contains: [\n");
        for (BookDecorator item : items) {
            sb.append("  - ").append(item.getDescription()).append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public double getPrice() {
        // The price is the sum of all items inside
        return items.stream().mapToDouble(BookDecorator::getPrice).sum();
    }
}