package com.bractits.apigateway.route;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;

public class AccountingRoute {

    public static Buildable<Route> route(PredicateSpec p) {
        return p.path("/accounting/**")
                .filters(f -> f.circuitBreaker(c -> c.setName("accountingCircuitBreaker").setFallbackUri("forward:/accountingServiceFallback"))
                        .rewritePath("/accounting/(?<segment>.*)", "/${segment}"))
                .uri("lb://ACCOUNTING-SERVICE");
    }
}
