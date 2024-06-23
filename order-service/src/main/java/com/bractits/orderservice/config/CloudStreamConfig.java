package com.bractits.orderservice.config;

import com.bractits.orderservice.orchestrator.PaymentHandler;
import com.bractits.orderservice.utils.event.payment.PaymentEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@AllArgsConstructor
@Configuration
public class CloudStreamConfig {

    private final PaymentHandler paymentHandler;

    @Bean
    public Consumer<Message<PaymentEvent>> paymentConsumer() {

        return message-> {
            System.out.println("paymentConsumer headers: "+message.getHeaders());
            System.out.println("paymentConsumer payload: "+message.getPayload());
            paymentHandler.paymentProcess(message.getPayload());

        };
    }


}
