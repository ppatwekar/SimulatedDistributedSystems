package com.example.demo.controller;

import com.example.demo.model.Catalog;
import com.example.demo.service.CatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private CatalogService catalogService;

    private static final Logger logger = LoggerFactory.getLogger(CatalogController.class);

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/")
    public ResponseEntity<Catalog> getCatalog(){
        long startTime = System.nanoTime();

        Catalog catalog = catalogService.getCatalog();

        long endTime = System.nanoTime();

        logger.info("TOTAL TIME REQUIRED="+(endTime-startTime)+"ns");

        return catalog!=null ? new ResponseEntity<>(catalog, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
