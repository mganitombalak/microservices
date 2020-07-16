package com.vodafone.productapi.model;

import lombok.Data;

@Data
public class GenericResponse<T> {

    private String rate;
    private Iterable<T> data;
    private String hostname;
}
