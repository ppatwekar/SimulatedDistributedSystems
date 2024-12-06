package com.example.demo.request;

import com.example.demo.model.Smartphone;
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
