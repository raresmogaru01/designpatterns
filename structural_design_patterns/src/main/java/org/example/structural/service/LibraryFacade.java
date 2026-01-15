package org.example.structural.service;

import org.example.structural.dto.BookDto;
import org.example.structural.entity.Book;
import org.example.structural.utils.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryFacade {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @Autowired
    public LibraryFacade(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    // --- Facade Method 1: Simplified Add ---
    public void addBook(BookDto bookDto) {
        // We convert DTO to Entity here, shielding the controller from Entity logic
        Book book = bookMapper.toEntity(bookDto);
        bookService.addBook(book);
    }

    // --- Facade Method 2: Get Featured Books (Decorator Pattern) ---
    public List<BookDto> getFeaturedBooks(String category) {
        List<Book> books = bookService.findByCategory(category);

        return books.stream().map(book -> {
            // 1. Create basic display (Leaf)
            BookDecorator display = new SimpleBookDisplay(book);

            // 2. Decorate it (mark as Featured)
            display = new FeaturedBookDecorator(display);

            // 3. Map back to DTO for the response
            BookDto dto = bookMapper.toDto(book);
            // Overwrite description and price with decorated values
            dto.setDescription(display.getDescription());
            dto.setPrice(display.getPrice());

            return dto;
        }).collect(Collectors.toList());
    }

    // Create book bundle
    public BookDto createBookBundle(String bundleName, List<Long> bookIds) {
        BookBundle bundle = new BookBundle(bundleName);

        List<Book> allBooks = bookService.getAllBooks();

        // filter to find only the books requested by ID
        List<Book> booksToAdd = allBooks.stream()
                .filter(b -> bookIds.contains(b.getId()))
                .collect(Collectors.toList());

        for (Book book : booksToAdd) {
            bundle.addItem(new SimpleBookDisplay(book));
        }

        // create a DTO to represent the whole bundle
        BookDto bundleDto = new BookDto();
        bundleDto.setTitle(bundleName);
        bundleDto.setCategory("Bundle");
        bundleDto.setAuthor("Collection");

        bundleDto.setDescription(bundle.getDescription());
        bundleDto.setPrice(bundle.getPrice());

        return bundleDto;
    }
}