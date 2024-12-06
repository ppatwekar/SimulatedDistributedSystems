package com.example.demo.request;

import com.example.demo.model.Laptop;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class LaptopsUpdateRequest {

    @Getter
    @Setter
    private List<Laptop> laptops;

    public LaptopsUpdateRequest(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public LaptopsUpdateRequest() {
    }
}
