package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.library.service.BookService;

public class Main {
    public static void main(String[] args) {
        // Load Spring context using annotation-based configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the BookService bean
        BookService bookService = context.getBean(BookService.class);

        // Use the BookService bean
        bookService.performService();
    }
}
