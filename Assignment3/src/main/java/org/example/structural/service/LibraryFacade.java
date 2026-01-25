package org.example.structural.service;


import org.example.structural.entity.Book;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.stream.Collectors;
import java.util.List;

@Component
public class LibraryFacade {

    private final BookService bookService;

    @Autowired
    public LibraryFacade(BookService bookService) {
        this.bookService = bookService;
    }

    // change addBook signature + body
    public Book addBook(Book book) {
        return bookService.addBook(book);
    }

    // add facade methods
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    public Book getBookById(Long id) {
        return bookService.getBookById(id);
    }

    public Book updateBook(Long id, Book updated) {
        return bookService.updateBook(id, updated);
    }

    public void deleteBook(Long id) {
        bookService.deleteBook(id);
    }

    public List<Book> findBooksByCategory(String category) {
        return bookService.findBooksByCategory(category);
    }

    // keep existing getFeaturedBooks(), but ensure it returns something (example)
    public List<Book> getFeaturedBooks() {
        return bookService.getAllBooks().stream().limit(2).collect(Collectors.toList());
    }

    // add decorator-backed facade outputs
    public List<String> getFeaturedBookDescriptions() {
        return bookService.getAllBooks()
                .stream()
                .limit(2)
                .map(b -> new FeaturedBookDecorator(b).getDescription())
                .collect(Collectors.toList());
    }

    public List<String> getBestsellerBookDescriptions() {
        return bookService.getAllBooks()
                .stream()
                .filter(b -> b.getPrice() >= 50)
                .map(b -> new BestsellerBookDecorator(b).getDescription())
                .collect(Collectors.toList());
    }
}
