package com.vodafone.productapi.model;

import lombok.Data;

@Data
public class GenericResponse<T> {
    private String hostname;
    private Iterable<T> data;
}
