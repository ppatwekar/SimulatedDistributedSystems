package com.example.demo.controller;

import com.example.demo.request.SmartphonesUpdateRequest;
import com.example.demo.service.DenormalizerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/update")
public class SmartphoneController {

    private DenormalizerService denormalizerService;

    private static final Logger logger = LoggerFactory.getLogger(SmartphoneController.class);

    public SmartphoneController(DenormalizerService denormalizerService) {
        this.denormalizerService = denormalizerService;
    }

   @PutMapping("/smartphones")
    public ResponseEntity<HttpStatus> updateSmartphones(@RequestBody SmartphonesUpdateRequest smartphonesUpdateRequest){
        denormalizerService.makeUpdateInDenormalizer(smartphonesUpdateRequest);
        return new ResponseEntity<>(HttpStatus.OK);
   }
}
