package com.example.BookstoreAPI.model;

import lombok.Data;

@Data
public class Book {
    private int id;
    private String title;
    private String author;
    private double price;
    private String isbn;
}
