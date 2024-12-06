package com.example.demo.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class SimulatedNetworkRequest {

    private RestTemplate restTemplate;

    @Value("${latencyLowerBound}")
    private int LATENCY_LOWER_BOUND;

    @Value("${latencyUpperBound}")
    private int LATENCY_UPPER_BOUND;

    private static final Logger logger = LoggerFactory.getLogger(SimulatedNetworkRequest.class);


    public SimulatedNetworkRequest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> void makePutRequest(String url, T body){
        simulateRandomLatency();
        restTemplate.put(url,body);
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
