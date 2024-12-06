package com.example.demo.service;

import com.example.demo.model.Catalog;
import com.example.demo.response.BookResponse;
import com.example.demo.response.LaptopResponse;
import com.example.demo.response.SmartphoneResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CatalogService {

    private SimulatedNetworkRequest simulatedNetworkRequest;

    @Value("${bookService.url}")
    private String bookServiceUrl;

    @Value("${laptopService.url}")
    private String laptopServiceUrl;


    @Value("${smartPhoneService.url}")
    private String smartPhoneServiceUrl;


    public CatalogService(SimulatedNetworkRequest simulatedNetworkRequest) {
        this.simulatedNetworkRequest = simulatedNetworkRequest;
    }

    public Catalog getCatalog(){
        Catalog catalog = new Catalog();

        BookResponse bookResponse = simulatedNetworkRequest.makeGetRequest(bookServiceUrl, BookResponse.class);
        LaptopResponse laptopResponse = simulatedNetworkRequest.makeGetRequest(laptopServiceUrl, LaptopResponse.class);
        SmartphoneResponse smartPhoneResponse = simulatedNetworkRequest.makeGetRequest(smartPhoneServiceUrl, SmartphoneResponse.class);


        catalog.setBooks(bookResponse.getBooks());

        catalog.setLaptops(laptopResponse.getLaptops());

        catalog.setSmartPhones(smartPhoneResponse.getSmartphones());

        return catalog;
    }
}
