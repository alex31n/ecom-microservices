package com.bractits.accountingservice.config;

import com.bractits.accountingservice.utils.event.OrderEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;


@Configuration
public class CloudStreamConfig {



    @Bean
    public Consumer<Message<OrderEvent>> orderConsumer() {

        return message-> {
            System.out.println("orderConsumer payload: "+message.getPayload());

            OrderEvent event = message.getPayload();
            System.out.println("orderConsumer event: "+event);
            /*try {
                ProductEvent event = mapper.readValue(message.getPayload(), ProductEvent.class);
                productHandler(event);
            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
            }*/


        };
    }


}
