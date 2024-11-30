package com.example.demo.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class SimulatedNetworkRequest {

    private RestTemplate restTemplate;

    private static final int LATENCY_LOWER_BOUND = 2000;
    private static final int LATENCY_UPPER_BOUND = 5000;

    private static final Logger logger = LoggerFactory.getLogger(SimulatedNetworkRequest.class);


    public SimulatedNetworkRequest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> T makeGetRequest(String url, Class<T> responseType){
        simulateRandomLatency();
        logger.info("MAKING REQUEST");
        return restTemplate.getForObject(url,responseType);
    }

    private void simulateRandomLatency(){
        int sleepTime = getRandomSleepTime();
        logger.info("SLEEPING FOR "+sleepTime+" seconds");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private int getRandomSleepTime(){
        return new Random().nextInt(LATENCY_UPPER_BOUND-999) + LATENCY_LOWER_BOUND;
    }
}
