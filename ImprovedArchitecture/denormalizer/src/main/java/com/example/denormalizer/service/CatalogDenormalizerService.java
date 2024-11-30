package com.example.denormalizer.service;


import com.example.denormalizer.dao.CatalogDao;
import org.springframework.stereotype.Service;

@Service
public class CatalogDenormalizerService {

    private CatalogDao catalogDao;

    public boolean updateBooks(){return false;}

    public boolean updateLaptops(){return false;}

    public boolean updateSmartphones(){return false;}

}
