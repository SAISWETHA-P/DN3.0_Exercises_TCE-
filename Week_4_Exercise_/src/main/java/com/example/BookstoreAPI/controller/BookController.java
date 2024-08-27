package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.mapper.BookMapper;
import com.example.BookstoreAPI.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = Arrays.asList(
        new Book(1, "Book One", "Author One", 29.99, "ISBN1111"),
        new Book(2, "Book Two", "Author Two", 39.99, "ISBN2222"),
        new Book(3, "Book Three", "Author Three", 49.99, "ISBN3333")
    );

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable int id) {
        Book book = books.stream()
            .filter(b -> b.getId() == id)
            .findFirst()
            .orElse(null);

        if (book == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        BookDTO bookDTO = BookMapper.INSTANCE.bookToBookDTO(book);
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.bookDTOToBook(bookDTO);
        // Logic to save the book (omitted for simplicity)
        return new ResponseEntity<>(bookDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return books.stream()
            .map(BookMapper.INSTANCE::bookToBookDTO)
            .collect(Collectors.toList());
    }
}
