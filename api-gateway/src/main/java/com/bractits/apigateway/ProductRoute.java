package com.bractits.apigateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;

public class ProductRoute {

    public static Buildable<Route> route(PredicateSpec p) {
        return p.path("/product/**")
                .filters(f -> f.circuitBreaker(c -> c.setName("productCircuitBreaker").setFallbackUri("forward:/productServiceFallback"))
                        .rewritePath("/product/(?<segment>.*)", "/${segment}"))
                .uri("lb://PRODUCT-SERVICE");
    }
}
