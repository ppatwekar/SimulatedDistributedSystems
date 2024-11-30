package com.example.denormalizer.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Catalog {
    @Getter @Setter
    private List<Book> books;

}
