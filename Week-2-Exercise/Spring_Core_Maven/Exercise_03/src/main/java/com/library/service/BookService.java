package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void performService() {
        System.out.println("Service is running");
        if (bookRepository != null) {
            bookRepository.saveBook();
        } else {
            System.out.println("No BookRepository injected");
        }
    }
}
