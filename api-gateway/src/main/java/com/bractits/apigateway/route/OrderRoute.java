package com.bractits.apigateway.route;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;

public class OrderRoute {

    public static Buildable<Route> route(PredicateSpec p) {
        return p.path("/order/**")
                .filters(f -> f.circuitBreaker(c -> c.setName("orderCircuitBreaker").setFallbackUri("forward:/orderServiceFallback"))
                        .rewritePath("/order/(?<segment>.*)", "/${segment}"))
                .uri("lb://ORDER-SERVICE");
    }
}
