package org.example.structural.dto;

import lombok.Data;

@Data
public class BookDto {
    private String title;
    private String author;
    private double price;

    // Added to match the Entity and allow filtering
    private String category;

    // Added to hold the dynamic output from the Decorator pattern
    private String description;
}