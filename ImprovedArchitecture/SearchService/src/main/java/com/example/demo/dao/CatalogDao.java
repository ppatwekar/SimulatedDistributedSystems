package com.example.demo.dao;

import com.example.demo.model.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

@Component
public class CatalogDao {
    private ResourceLoader resourceLoader;
    private ObjectMapper objectMapper;

    @Value("${catalogFileLocation}")
    private String catalogFileLocation;


    private long lastModifiedTime;

    private static final Logger logger = LoggerFactory.getLogger(CatalogDao.class);

    public CatalogDao(ResourceLoader resourceLoader, ObjectMapper objectMapper) {
        this.resourceLoader = resourceLoader;
        this.objectMapper = objectMapper;
    }

    @Scheduled(fixedRate = 3000)
    public void checkLastModified(){
        try {
            logger.info("CHECKING IF FILE WAS MODIFIED");
            long modifiedTime = Files.getLastModifiedTime(Paths.get(catalogFileLocation)).toMillis();
            if(modifiedTime > lastModifiedTime) {
                lastModifiedTime = modifiedTime;
                logger.info("FILE WAS LAST MODIFIED AT " + new Date(lastModifiedTime).toString());
            }
        } catch (IOException e) {
            logger.error("Could not get last modified time "+e.getMessage());
        }
    }

    public Catalog getCatalog() throws IOException {
        Resource resource = resourceLoader.getResource("file:"+catalogFileLocation);
        return objectMapper.readValue(resource.getInputStream(), Catalog.class);
    }
}
