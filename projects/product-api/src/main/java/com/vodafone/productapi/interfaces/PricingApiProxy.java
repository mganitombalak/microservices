package com.vodafone.productapi.interfaces;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name="pricing-api",url="localhost:8081")
@FeignClient(name="pricing-api")
@RibbonClient(name = "pricing-api")
public interface PricingApiProxy {
    @GetMapping("api/pricing")
    public String Get();
}
