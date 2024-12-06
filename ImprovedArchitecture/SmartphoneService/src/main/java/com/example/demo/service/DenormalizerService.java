package com.example.demo.service;

import com.example.demo.request.SmartphonesUpdateRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DenormalizerService {

    private SimulatedNetworkRequest simulatedNetworkRequest;

    @Value("${denormalizer.url}")
    private String denormalizerUrl;



    public DenormalizerService(SimulatedNetworkRequest simulatedNetworkRequest) {
        this.simulatedNetworkRequest = simulatedNetworkRequest;
    }

   public void makeUpdateInDenormalizer(SmartphonesUpdateRequest SmartphonesUpdateRequest){
        simulatedNetworkRequest.makePutRequest(denormalizerUrl, SmartphonesUpdateRequest);
   }
}
