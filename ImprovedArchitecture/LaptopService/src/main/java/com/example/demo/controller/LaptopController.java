package com.example.demo.controller;

import com.example.demo.request.LaptopsUpdateRequest;
import com.example.demo.service.DenormalizerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/update")
public class LaptopController {

    private DenormalizerService denormalizerService;

    private static final Logger logger = LoggerFactory.getLogger(LaptopController.class);

    public LaptopController(DenormalizerService denormalizerService) {
        this.denormalizerService = denormalizerService;
    }

   @PutMapping("/books")
    public ResponseEntity<HttpStatus> updateBooks(@RequestBody LaptopsUpdateRequest laptopsUpdateRequest){
        denormalizerService.makeUpdateInDenormalizer(laptopsUpdateRequest);
        return new ResponseEntity<>(HttpStatus.OK);
   }
}
