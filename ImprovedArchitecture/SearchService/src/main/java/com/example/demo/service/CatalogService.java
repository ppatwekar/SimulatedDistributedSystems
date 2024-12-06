package com.example.demo.service;

import com.example.demo.dao.CatalogDao;
import com.example.demo.model.Catalog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CatalogService {

    private CatalogDao catalogDao;

    private static final Logger logger = LoggerFactory.getLogger(CatalogService.class);

    public CatalogService(CatalogDao catalogDao) {
        this.catalogDao = catalogDao;
    }

    public Catalog getCatalog(){
        try {
            return catalogDao.getCatalog();
        } catch (IOException e) {
            logger.error("Error getting Catalog from DAO");
            return null;
        }
    }
}
