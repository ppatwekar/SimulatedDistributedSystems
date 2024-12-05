package com.example.demo.service;


import com.example.demo.model.Smartphone;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class SmartphoneService {

    private ObjectMapper objectMapper;
    private ResourceLoader resourceLoader;

    private static final Logger logger = LoggerFactory.getLogger(SmartphoneService.class);

    public SmartphoneService(ObjectMapper objectMapper, ResourceLoader resourceLoader) {
        this.objectMapper = objectMapper;
        this.resourceLoader = resourceLoader;
    }

    public List<Smartphone> getSmartphones() throws IOException {
        logger.info("Loading Resource and getting smartphones...");
        Resource resource = resourceLoader.getResource("classpath:smartphones.json");
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Smartphone>>() {});
    }
}
