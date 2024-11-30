package com.example.denormalizer.dao;

import com.example.denormalizer.model.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class CatalogDao {

    private ObjectMapper objectMapper;

    private ResourceLoader resourceLoader;

    public CatalogDao(ObjectMapper objectMapper, ResourceLoader resourceLoader) {
        this.objectMapper = objectMapper;
        this.resourceLoader = resourceLoader;
    }

    public Catalog getCatalog(){return null;}

    public boolean updateCatalog(Catalog catalog){return false;}

    private Catalog loadCatalogFromFile(){
        //use file:../shared/data/catalog.json in resourceLoader
        return null;
    }

}
