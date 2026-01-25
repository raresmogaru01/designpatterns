package org.example.structural.dto;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String category;
    private String title;
    private String author;
    private double price;
}
