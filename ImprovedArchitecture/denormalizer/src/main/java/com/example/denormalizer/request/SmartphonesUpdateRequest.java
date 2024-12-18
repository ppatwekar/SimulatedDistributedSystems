package com.example.denormalizer.request;

import com.example.denormalizer.model.Laptop;
import com.example.denormalizer.model.Smartphone;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class SmartphonesUpdateRequest {

    @Getter
    @Setter
    private List<Smartphone> smartphones;

    public SmartphonesUpdateRequest(List<Smartphone> smartphones) {
        this.smartphones = smartphones;
    }

    public SmartphonesUpdateRequest() {
    }
}
