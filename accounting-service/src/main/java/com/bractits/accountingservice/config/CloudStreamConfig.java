package com.bractits.accountingservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;


@Configuration
public class CloudStreamConfig {



    @Bean
    public Consumer<Message<String>> orderConsumer() {

        return message-> {
            System.out.println("orderConsumer payload: "+message.getPayload());

            /*try {
                ProductEvent event = mapper.readValue(message.getPayload(), ProductEvent.class);
                productHandler(event);
            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
            }*/


        };
    }


}
