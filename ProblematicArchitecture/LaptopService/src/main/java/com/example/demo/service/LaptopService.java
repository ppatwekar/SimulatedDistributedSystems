package com.example.demo.service;


import com.example.demo.model.Laptop;
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
public class LaptopService {

    private ObjectMapper objectMapper;
    private ResourceLoader resourceLoader;

    private static final Logger logger = LoggerFactory.getLogger(LaptopService.class);

    public LaptopService(ObjectMapper objectMapper, ResourceLoader resourceLoader) {
        this.objectMapper = objectMapper;
        this.resourceLoader = resourceLoader;
    }

    public List<Laptop> getLaptops() throws IOException {
        logger.info("Loading Resource and getting laptops...");
        Resource resource = resourceLoader.getResource("classpath:laptops.json");
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Laptop>>() {});
    }
}
