package com.example.demo.service;

import com.example.demo.model.Catalog;
import com.example.demo.response.BookResponse;
import org.springframework.stereotype.Service;

@Service
public class CatalogService {

    private SimulatedNetworkRequest simulatedNetworkRequest;

    public CatalogService(SimulatedNetworkRequest simulatedNetworkRequest) {
        this.simulatedNetworkRequest = simulatedNetworkRequest;
    }

    public Catalog getCatalog(){
        Catalog catalog = new Catalog();

        BookResponse bookResponse = simulatedNetworkRequest.makeGetRequest("http://localhost:8080/books", BookResponse.class);

        catalog.setBooks(bookResponse.getBooks());
        return catalog;
    }
}
