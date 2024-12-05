package com.example.demo.response;

import com.example.demo.model.Laptop;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class LaptopResponse
{
    @Getter @Setter
    private List<Laptop> laptops;

    public LaptopResponse(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public LaptopResponse() {
    }
}
