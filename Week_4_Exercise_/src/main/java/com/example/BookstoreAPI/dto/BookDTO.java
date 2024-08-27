package com.example.BookstoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private int id;
    private String title;
    private String author;
    private double price;
    private String isbn;

    @JsonGetter("bookTitle")
    public String getTitle() {
        return title;
    }

    @JsonSetter("bookTitle")
    public void setTitle(String title) {
        this.title = title;
    }
}
