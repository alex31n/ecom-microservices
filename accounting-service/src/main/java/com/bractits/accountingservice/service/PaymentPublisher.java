package com.bractits.accountingservice.service;


import com.bractits.accountingservice.data.dto.PaymentDTO;
import com.bractits.accountingservice.utils.event.PaymentAction;
import com.bractits.accountingservice.utils.event.PaymentEvent;
import com.bractits.accountingservice.utils.event.Status;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentPublisher {

//
    private final StreamBridge streamBridge;


    public void send(PaymentAction action, PaymentDTO payment) {
        log.error("PaymentPublisher send: action "+action+"  payment "+payment);
        PaymentEvent event = PaymentEvent.builder()
                .data(payment)
                .action(action)
                .status(Status.SUCCESS)
                .build();

        Message<PaymentEvent> message = MessageBuilder.withPayload(event)
                .build();
        streamBridge.send("paymentSupplier-out-0", message);
    }
}
