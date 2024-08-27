package com.example.BookstoreAPI.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public List<String> getAllBooks() {
        return Arrays.asList("Book1", "Book2", "Book3");
    }

    @PostMapping
    public String createBook() {
        return "Book created";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id) {
        return "Book with ID " + id + " updated";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        return "Book with ID " + id + " deleted";
    }
}
