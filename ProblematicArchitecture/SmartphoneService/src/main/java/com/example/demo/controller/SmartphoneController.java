package com.example.demo.controller;

import com.example.demo.model.Smartphone;
import com.example.demo.response.SmartphoneResponse;
import com.example.demo.service.SmartphoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class SmartphoneController {


    public SmartphoneController(SmartphoneService smartphoneService) {
        this.smartphoneService = smartphoneService;
    }

    private static Logger logger = LoggerFactory.getLogger(SmartphoneController.class);

    private SmartphoneService smartphoneService;

    @GetMapping("/smartphones")
    public ResponseEntity<SmartphoneResponse> getSmartphones(){
        logger.info("Received request to get all smartphone...");
        long startTime = System.currentTimeMillis();
        try {
            List<Smartphone> smartphones = smartphoneService.getSmartphones();
            long endTime = System.currentTimeMillis();
            logger.info("TOTAL TIME "+(endTime-startTime)+"ms");
            return new ResponseEntity<>(new SmartphoneResponse(smartphones), HttpStatus.OK);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
