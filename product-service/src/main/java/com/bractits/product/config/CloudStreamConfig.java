package com.bractits.product.config;

import com.bractits.product.utils.event.ProductEvent;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


@Configuration
public class CloudStreamConfig {

    /*@Bean
    public Supplier<ProductEvent> productSupplier() {
        return ()-> new ProductEvent();
    }*/

    @Bean
    public Sinks.Many<ProductEvent> productSinks(){
        return Sinks.many().multicast().onBackpressureBuffer();
    }

    /*@Bean
    public Supplier<Flux<ProductEvent>> productSupplier(Sinks.Many<ProductEvent> sinks) {
        return sinks::asFlux;
    }*/


    /*@Bean
    public Function<String, String> productSupplier() {
        return event-> {
            System.out.println(event);
            return event;
        };

    }*/

    /*@Bean
    public Supplier<String> productSupplier(StreamBridge streamBridge) {
        return event-> event;


    }*/

    /*@Bean
    public Consumer<String> productSupplier() {
        return System.out::println;
    }*/

   /* @Bean
    public Supplier<ProductEvent> productSupplier() {
//        log.info("Conuming message......................");
//        Supplier<ProductEvent> consumer = (request)-> System.out.println(Flux.just(request));
//        System.out.println(consumer);
        return  (request)-> request.;
    }*/


}
