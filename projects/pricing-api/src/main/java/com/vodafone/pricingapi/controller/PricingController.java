package com.vodafone.pricingapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pricing")
public class PricingController {
    @Value("${environment:No Env Selected}")
    private String environment;
    @Value("${exchange.rate:0.0}")
    private double exchangeRate;
    @Value("${exchange.currency:NoCurr}")
    private String exchangeCurrency;

    @GetMapping("env")
    public String GetEnv(){
        return this.environment;
    }
    @GetMapping
    public String Get(){
        return this.exchangeCurrency + " " + this.exchangeRate;
    }

}
