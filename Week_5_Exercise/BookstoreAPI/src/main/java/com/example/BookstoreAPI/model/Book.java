package com.example.BookstoreAPI.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@EntityScan
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String title;

    @NotNull
    @Size(min = 2, max = 50)
    private String author;

    @Min(0)
    private double price;

    @NotNull
    private String isbn;

    @Version
    private Integer version;
}
