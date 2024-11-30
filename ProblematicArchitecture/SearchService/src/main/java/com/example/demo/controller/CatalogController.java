package com.example.demo.controller;

import com.example.demo.model.Catalog;
import com.example.demo.service.CatalogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/")
    public ResponseEntity<Catalog> getCatalog(){
        Catalog catalog = catalogService.getCatalog();
        return new ResponseEntity<>(catalog, HttpStatus.OK);
    }
}
