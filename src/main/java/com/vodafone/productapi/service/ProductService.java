package com.vodafone.productapi.service;

import com.vodafone.productapi.entity.Product;
import com.vodafone.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Iterable<Product> findAll(){
        return this.repository.findAll();
    }
}
