package com.bractits.apigateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping("/productServiceFallback")
    public String productServiceFallback(){
        return "Product service is down!";
    }

    @RequestMapping("/searchServiceFallback")
    public String searchServiceFallback(){
        return "Search service is down!";
    }

    @RequestMapping("/orderServiceFallback")
    public String orderServiceFallback(){
        return "Order service is down!";
    }

    @RequestMapping("/inventoryServiceFallback")
    public String inventoryServiceFallback(){
        return "Inventory service is down!";
    }

    @RequestMapping("/accountingServiceFallback")
    public String accountingServiceFallback(){
        return "Accounting service is down!";
    }


}
