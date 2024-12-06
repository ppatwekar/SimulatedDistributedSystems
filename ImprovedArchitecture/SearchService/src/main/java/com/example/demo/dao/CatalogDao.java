package com.example.demo.dao;

import com.example.demo.model.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CatalogDao {
    private ResourceLoader resourceLoader;
    private ObjectMapper objectMapper;

    @Value("${catalogFileLocation}")
    private String catalogFileLocation;

    public CatalogDao(ResourceLoader resourceLoader, ObjectMapper objectMapper) {
        this.resourceLoader = resourceLoader;
        this.objectMapper = objectMapper;
    }

    public Catalog getCatalog() throws IOException {
        Resource resource = resourceLoader.getResource("file:"+catalogFileLocation);
        return objectMapper.readValue(resource.getInputStream(), Catalog.class);
    }
}
