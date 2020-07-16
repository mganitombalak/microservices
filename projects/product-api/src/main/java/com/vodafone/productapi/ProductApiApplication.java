package com.vodafone.productapi;

import com.vodafone.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.vodafone.productapi")
@EnableDiscoveryClient
public class ProductApiApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ProductApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        repository.deleteAll();
//        repository.save(new Product("product-1","IPhoneX"));
//        repository.save(new Product("product-2","Xaomi 9T Pro"));
    }
}
