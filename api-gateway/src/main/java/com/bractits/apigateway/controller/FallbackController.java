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


}
