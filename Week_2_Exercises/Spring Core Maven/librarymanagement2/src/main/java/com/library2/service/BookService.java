package com.library2.service;

import org.springframework.stereotype.Service;
import com.library2.repository.BookRepository;

@Service
public class BookService {
    private BookRepository bookRepository;

    // Constructor for constructor-based dependency injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void manageBooks() {
        System.out.println("Managing books...");
        bookRepository.getBooks();
    }
}
