package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

public class Smartphone
{
        @Getter
        @Setter
        private String name;

        @Getter
        @Setter
        private int price;

        public Smartphone(String name, int price)
        {
            this.name = name;
            this.price = price;
        }
}
