package com.bractits.orderservice.service;


import com.bractits.orderservice.data.dto.OrderDTO;
import com.bractits.orderservice.utils.event.Action;
import com.bractits.orderservice.utils.event.OrderEvent;
import com.bractits.orderservice.utils.event.Status;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class OrderPublisher {

//
    private final StreamBridge streamBridge;


    public void publish(Action action, OrderDTO obj) {
        log.error("OrderPublisher createOrder: action "+action+"  obj "+obj);
        OrderEvent event = OrderEvent.builder()
                .data(obj)
                .action(action)
                .status(Status.SUCCESS)
                .build();

        Message<OrderEvent> message = MessageBuilder.withPayload(event)
                .build();
        streamBridge.send("orderSupplier-out-0", message);
    }
}
