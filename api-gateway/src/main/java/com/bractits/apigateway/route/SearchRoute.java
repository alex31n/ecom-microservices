package com.bractits.apigateway.route;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;

public class SearchRoute {

    public static Buildable<Route> route(PredicateSpec p) {
        return p.path("/search/**")
                .filters(f -> f.circuitBreaker(c -> c.setName("searchCircuitBreaker").setFallbackUri("forward:/searchServiceFallback"))
                        .rewritePath("/search/(?<segment>.*)", "/${segment}"))
                .uri("lb://SEARCH-SERVICE");
    }
}
