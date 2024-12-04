package com.example.denormalizer.dao;

import com.example.denormalizer.model.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class CatalogDao {

    private ObjectMapper objectMapper;

    private ResourceLoader resourceLoader;

    private static final Logger logger = LoggerFactory.getLogger(Catalog.class);

    public CatalogDao(ObjectMapper objectMapper, ResourceLoader resourceLoader) {
        this.objectMapper = objectMapper;
        this.resourceLoader = resourceLoader;
    }

    public Catalog getCatalog(){
        logger.info("Loading Catalog from File");
        try {
            return loadCatalogFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCatalog(Catalog catalog){
        logger.info("Updating catalog");
        File file = new File("../shared/data/catalog.json");
        try {
            objectMapper.writeValue(file,catalog);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Catalog loadCatalogFromFile() throws IOException {
        //use file:../shared/data/catalog.json in resourceLoader
        Resource resource = resourceLoader.getResource("file:../shared/data/catalog.json");
        return objectMapper.readValue(resource.getInputStream(),Catalog.class);
    }

}
