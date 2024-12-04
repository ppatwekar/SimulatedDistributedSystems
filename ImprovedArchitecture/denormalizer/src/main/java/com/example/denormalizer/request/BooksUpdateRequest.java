package com.example.denormalizer.request;

import com.example.denormalizer.model.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class BooksUpdateRequest {

    @Getter @Setter
    private List<Book> books;

    public BooksUpdateRequest() {
    }

    public BooksUpdateRequest(List<Book> books) {
        this.books = books;
    }
}
