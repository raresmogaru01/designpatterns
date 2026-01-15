package org.example.structural.utils;

import org.example.structural.dto.BookDto;
import org.example.structural.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {


    public BookDto toDto(Book book) {
        BookDto dto = new BookDto();
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setPrice(book.getPrice());
        dto.setCategory(book.getCategory());
        return dto;
    }

    public Book toEntity(BookDto dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        book.setCategory(dto.getCategory());
        return book;
    }
}