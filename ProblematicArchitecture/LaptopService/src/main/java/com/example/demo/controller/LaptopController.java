package com.example.demo.controller;

import com.example.demo.model.Laptop;
import com.example.demo.response.LaptopResponse;
import com.example.demo.service.LaptopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class LaptopController {


    public LaptopController(LaptopService latopService) {
        this.latopService = latopService;
    }

    private static Logger logger = LoggerFactory.getLogger(LaptopController.class);

    private LaptopService latopService;

    @GetMapping("/laptops")
    public ResponseEntity<LaptopResponse> getLaptops(){
        logger.info("Received request to get all laptops...");
        long startTime = System.currentTimeMillis();
        try {
            List<Laptop> laptops = latopService.getLaptops();
            long endTime = System.currentTimeMillis();
            logger.info("TOTAL TIME "+(endTime-startTime)+"ms");
            return new ResponseEntity<>(new LaptopResponse(laptops), HttpStatus.OK);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
