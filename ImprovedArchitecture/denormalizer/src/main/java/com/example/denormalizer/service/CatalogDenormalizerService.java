package com.example.denormalizer.service;


import com.example.denormalizer.dao.CatalogDao;
import com.example.denormalizer.model.Book;
import com.example.denormalizer.model.Catalog;
import com.example.denormalizer.model.Laptop;
import com.example.denormalizer.model.Smartphone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogDenormalizerService {

    private CatalogDao catalogDao;

    private static final Logger logger = LoggerFactory.getLogger(CatalogDenormalizerService.class);

    public CatalogDenormalizerService(CatalogDao catalogDao) {
        this.catalogDao = catalogDao;
    }

    public void updateBooks(List<Book> books){
        Catalog catalog = catalogDao.getCatalog();
        catalog.setBooks(books);
        catalogDao.updateCatalog(catalog);
    }

    public void updateLaptops(List<Laptop> laptops){
        Catalog catalog = catalogDao.getCatalog();
        catalog.setLaptops(laptops);
        catalogDao.updateCatalog(catalog);
    }

    public void updateSmartphones(List<Smartphone> smartphones){
        Catalog catalog = catalogDao.getCatalog();
        catalog.setSmartphones(smartphones);
        catalogDao.updateCatalog(catalog);
    }


}
