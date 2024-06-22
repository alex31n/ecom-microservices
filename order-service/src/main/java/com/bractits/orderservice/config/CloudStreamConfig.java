package com.bractits.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;


@Configuration
public class CloudStreamConfig {


    @Bean
    public Consumer<Message<String>> paymentConsumer() {

        return message-> {
            System.out.println("paymentConsumer headers: "+message.getHeaders());
            System.out.println("paymentConsumer payload: "+message.getPayload());

        };
    }


}
