package com.vodafone.productapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 125)
    private String name;
    private String brand;
    private boolean isActive;

}
