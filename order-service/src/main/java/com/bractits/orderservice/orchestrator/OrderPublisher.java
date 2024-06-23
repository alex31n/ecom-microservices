package com.bractits.orderservice.orchestrator;

import com.bractits.orderservice.data.dto.OrderDTO;
import com.bractits.orderservice.utils.event.OrderEvent;
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


    public void orderCreated(OrderDTO obj) {
        OrderEvent event = OrderEvent.builder()
                .orderId(obj.getId())
                .userId(obj.getUserId())
                .amount(obj.getAmount())
                .build();

        Message<OrderEvent> message = MessageBuilder.withPayload(event)
                .build();
        streamBridge.send("order.created", message);
    }

    public void orderCancelled(OrderDTO obj) {
        /*OrderEvent event = OrderEvent.builder()
                .data(obj)
                .status(Status.SUCCESS)
                .build();

        Message<OrderEvent> message = MessageBuilder.withPayload(event)
                .build();
        streamBridge.send("order.cancelled", message);*/
    }

}
