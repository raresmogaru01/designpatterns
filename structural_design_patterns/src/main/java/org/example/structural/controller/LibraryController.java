package org.example.structural.controller;

import org.example.structural.dto.BookDto;
import org.example.structural.service.LibraryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/books")
public class LibraryController {

    private final LibraryFacade libraryFacade;

    @Autowired
    public LibraryController(LibraryFacade libraryFacade) {
        this.libraryFacade = libraryFacade;
    }

    @PostMapping
    public void addBook(@RequestBody BookDto bookDto) {
        libraryFacade.addBook(bookDto);
    }

    @GetMapping("/featured/{category}")
    public List<BookDto> getFeaturedBooks(@PathVariable String category) {
        return libraryFacade.getFeaturedBooks(category);
    }

    // Endpoint to create a bundle (Composite Pattern)
    // Usage: POST /api/books/bundle?name=SummerRead&ids=1,2
    @PostMapping("/bundle")
    public BookDto createBundle(@RequestParam String name, @RequestParam List<Long> ids) {
        return libraryFacade.createBookBundle(name, ids);
    }
}