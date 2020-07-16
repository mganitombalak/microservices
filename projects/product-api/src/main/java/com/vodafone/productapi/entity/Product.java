package com.vodafone.productapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Product {
    @Id
    public String id;
    public String productName;
}
