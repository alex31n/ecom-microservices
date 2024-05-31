package com.bractits.search.config;

import com.bractits.search.data.event.ProductEvent;
import com.bractits.search.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Slf4j
@Configuration
@AllArgsConstructor
public class CloudStreamConfig {

    private final ProductService productService;

    private final ObjectMapper mapper;

    @Bean
    public Consumer<Message<String>> productConsumer() {
//        return this::productHandler;
//        return message-> message.getPayload();

        return message-> {
//            System.out.println("productConsumer payload: "+message.getPayload());
            try {
                ProductEvent event = mapper.readValue(message.getPayload(), ProductEvent.class);
                productHandler(event);
            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
            }


        };
    }

    private void productHandler(ProductEvent productEvent) {
        switch (productEvent.getStatus()){
            case SUCCESS -> productService.create(productEvent.getProduct());
            default -> {}
        }

    }

   /* @Bean
    MessageConverter messageConverter(){
        return new JsonbMessageConverter();
    }*/


}
