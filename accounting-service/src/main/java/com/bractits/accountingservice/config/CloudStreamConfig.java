package com.bractits.accountingservice.config;

import com.bractits.accountingservice.service.PaymentService;
import com.bractits.accountingservice.utils.event.OrderEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;


@AllArgsConstructor
@Configuration
public class CloudStreamConfig {

    private final PaymentService paymentService;


    @Bean
    public Consumer<Message<OrderEvent>> orderConsumer() {

        return message-> {
            System.out.println("orderConsumer headers: "+message.getHeaders());
            System.out.println("orderConsumer payload: "+message.getPayload());

//            OrderEvent event = message.getPayload();
//            System.out.println("orderConsumer event: "+event);
            /*try {
                ProductEvent event = mapper.readValue(message.getPayload(), ProductEvent.class);
                productHandler(event);
            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
            }*/

            orderEventHandler(message.getPayload());

        };
    }

    private void orderEventHandler(OrderEvent orderEvent){
        System.out.println("orderEventHandler OrderEvent: "+orderEvent);
        /*switch (orderEvent.getAction()){
            case PLACED -> paymentService.createOrUpdateFromOrderEvent(orderEvent.);
            case CANCELLED -> paymentService.createOrUpdateFromOrderEvent(orderEvent);
        }*/
    }

}
