package com.bractits.search.config;

import com.bractits.search.data.event.ProductEvent;
import com.bractits.search.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;


@Configuration
@AllArgsConstructor
public class CloudStreamConfig {

    private final ProductService productService;

    @Bean
    public Consumer<ProductEvent> productConsumer() {
        return this::productHandler;
    }

    private void productHandler(ProductEvent productEvent) {

        switch (productEvent.getStatus()){
            case SUCCESS -> productService.create(productEvent.getProduct());
            default -> {}
        }

    }


}
