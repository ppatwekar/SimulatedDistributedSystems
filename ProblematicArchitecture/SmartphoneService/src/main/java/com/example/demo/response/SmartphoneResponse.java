package com.example.demo.response;

import com.example.demo.model.SmartPhone;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class SmartphoneResponse {
    @Getter @Setter
    private List<Smartphone> smartphones;

    public SmartphoneResponse(List<Smartphone> smartphones) {
        this.smartphones = smartphones;
    }

    public SmartphoneResponse() {
    }
}
