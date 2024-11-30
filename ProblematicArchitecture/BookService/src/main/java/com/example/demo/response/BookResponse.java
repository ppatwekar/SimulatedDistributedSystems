package com.example.demo.response;

import com.example.demo.model.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class BookResponse {
    @Getter @Setter
    private List<Book> books;

    public BookResponse(List<Book> books) {
        this.books = books;
    }

    public BookResponse() {
    }
}
