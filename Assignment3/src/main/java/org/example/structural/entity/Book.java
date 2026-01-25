package org.example.structural.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.structural.service.BookDecorator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements BookDecorator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String author;
    double price;
    String category;

    public String getDescription() {
        return title + " by " + author + (category != null ? " (" + category + ")" : "");
    }

    @Override
    public double getPrice() {
        return price;
    }
}
