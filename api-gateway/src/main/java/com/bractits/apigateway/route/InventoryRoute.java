package com.bractits.apigateway.route;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;

public class InventoryRoute {

    public static Buildable<Route> route(PredicateSpec p) {
        return p.path("/inventory/**")
                .filters(f -> f.circuitBreaker(c -> c.setName("inventoryCircuitBreaker").setFallbackUri("forward:/inventoryServiceFallback"))
                        .rewritePath("/inventory/(?<segment>.*)", "/${segment}"))
                .uri("lb://INVENTORY-SERVICE");
    }
}
