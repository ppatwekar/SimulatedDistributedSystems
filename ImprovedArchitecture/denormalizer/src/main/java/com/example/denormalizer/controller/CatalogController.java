package com.example.denormalizer.controller;

import com.example.denormalizer.request.BooksUpdateRequest;
import com.example.denormalizer.request.LaptopsUpdateRequest;
import com.example.denormalizer.request.SmartphonesUpdateRequest;
import com.example.denormalizer.service.CatalogDenormalizerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/update")
public class CatalogController {

    private static final Logger logger = LoggerFactory.getLogger(CatalogController.class);

    private CatalogDenormalizerService catalogDenormalizerService;

    public CatalogController(CatalogDenormalizerService catalogDenormalizerService) {
        this.catalogDenormalizerService = catalogDenormalizerService;
    }

    @PostMapping("/books")
    public HttpStatus updateBooks(@RequestBody BooksUpdateRequest booksUpdateRequest){
        logger.info("Received Request to update Books");
        catalogDenormalizerService.updateBooks(booksUpdateRequest.getBooks());
        return HttpStatus.OK;
    }


    @PostMapping("/laptops")
    public void updateLaptops(@RequestBody LaptopsUpdateRequest laptopsUpdateRequest){
        catalogDenormalizerService.updateLaptops(null);
    }

    @PostMapping("/smartphones")
    public void updateSmartphones(@RequestBody SmartphonesUpdateRequest smartphonesUpdateRequest){
        catalogDenormalizerService.updateSmartphones(null);
    }
}
