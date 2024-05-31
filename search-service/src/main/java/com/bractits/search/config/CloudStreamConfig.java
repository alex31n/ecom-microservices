package com.bractits.search.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;


@Configuration
public class CloudStreamConfig {

    @Bean
    public Consumer<String> productConsumer() {
        return System.out::println;
    }


}
