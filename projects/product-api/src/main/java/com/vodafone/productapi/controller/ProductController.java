package com.vodafone.productapi.controller;

import com.netflix.discovery.EurekaClient;
import com.vodafone.productapi.entity.Product;
import com.vodafone.productapi.interfaces.PricingApiProxy;
import com.vodafone.productapi.model.GenericResponse;
import com.vodafone.productapi.service.ProductService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private PricingApiProxy pricingApiProxy;

    @Value("${environment:No Env Selected}")
    private String environment;

    private ProductService service;

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient client;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }
    @GetMapping("env")
    public String GetEnv(){
        return this.environment;
    }
    @GetMapping
    public Iterable<Product> Get(){
        return this.service.findAll();
    }

    @GetMapping("rate")
    public GenericResponse<Product> GetPrice() throws UnknownHostException {
        var result = new GenericResponse<Product>();
        result.setData(this.service.findAll());
        result.setHostname(InetAddress.getLocalHost().getHostName());
//        var r=client.getApplication("PRICING-API");
//        r.getInstances()
        result.setRate(new RestTemplate().getForObject("http://localhost:8081/api/pricing",String.class));
        return result;
    }
    @GetMapping("feign/rate")
    public GenericResponse<Product> GetPriceWithFeign() throws UnknownHostException {
        var result = new GenericResponse<Product>();
        result.setData(this.service.findAll());
        result.setHostname(InetAddress.getLocalHost().getHostName());
        result.setRate(pricingApiProxy.Get());
        return result;
    }
}
