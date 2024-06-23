package com.bractits.inventoryservice.config;

import com.bractits.inventoryservice.utils.event.OrderEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;


@AllArgsConstructor
@Configuration
public class CloudStreamConfig {


    @Bean
    public Consumer<Message<OrderEvent>> orderCreatedConsumer() {

        return message -> {
            System.out.println("orderCreatedConsumer headers: " + message.getHeaders());
            System.out.println("orderCreatedConsumer payload: " + message.getPayload());

            /*OrderDTO order = message.getPayload().getData();
            paymentService.create(
                    PaymentDTO.builder()
                            .orderId(order.getId())
                            .amount(order.getAmount())
                            .status(Payment.Status.WAITING)
                            .build()
            );*/
        };
    }

}
