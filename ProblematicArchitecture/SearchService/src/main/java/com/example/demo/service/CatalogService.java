package com.example.demo.service;

import com.example.demo.model.Catalog;
import com.example.demo.response.BookResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CatalogService {

    private SimulatedNetworkRequest simulatedNetworkRequest;

    @Value("${bookService.url}")
    private String bookServiceUrl;

    public CatalogService(SimulatedNetworkRequest simulatedNetworkRequest) {
        this.simulatedNetworkRequest = simulatedNetworkRequest;
    }

    public Catalog getCatalog(){
        Catalog catalog = new Catalog();

        BookResponse bookResponse = simulatedNetworkRequest.makeGetRequest(bookServiceUrl, BookResponse.class);

        catalog.setBooks(bookResponse.getBooks());
        return catalog;
    }
}
