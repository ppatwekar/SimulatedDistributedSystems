package com.example.denormalizer.request;

import com.example.denormalizer.model.Laptop;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class LaptopsUpdateRequest {

    @Getter @Setter
    private List<Laptop> laptops;

    public LaptopsUpdateRequest(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public LaptopsUpdateRequest() {
    }
}
