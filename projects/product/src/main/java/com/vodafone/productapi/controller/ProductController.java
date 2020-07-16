package com.vodafone.productapi.controller;

import com.vodafone.productapi.entity.Product;
import com.vodafone.productapi.model.GenericResponse;
import com.vodafone.productapi.service.ProductService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity Get() throws UnknownHostException {
        var result = new GenericResponse<Product>();
        result.setData(service.findAll());
        result.setHostname(InetAddress.getLocalHost().getHostName());
        return ResponseEntity.ok(result);
    }
}
