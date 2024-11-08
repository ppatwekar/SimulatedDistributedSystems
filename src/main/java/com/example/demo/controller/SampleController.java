package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class SampleController {


    public SampleController(BookService bookService) {
        this.bookService = bookService;
    }

    private static Logger logger = LoggerFactory.getLogger(SampleController.class);

    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        logger.info("Received request to get all books...");
        long startTime = System.currentTimeMillis();
        try {
            List<Book> books = bookService.getBooks();
            long endTime = System.currentTimeMillis();
            logger.info("TOTAL TIME "+(endTime-startTime)+"ms");
            return new ResponseEntity<>(books, HttpStatus.OK);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
