package com.example.demo.request;

import com.example.demo.model.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class BooksUpdateRequest {
    @Getter
    @Setter
    private List<Book> books;

    public BooksUpdateRequest(List<Book> books) {
        this.books = books;
    }

    public BooksUpdateRequest() {
    }
}
