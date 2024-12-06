package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Catalog {
    @Getter @Setter
    private List<Book> books;

    @Getter @Setter
    private List<Laptop> laptops;

    @Getter @Setter
    private List<Smartphone> smartPhones;

}
