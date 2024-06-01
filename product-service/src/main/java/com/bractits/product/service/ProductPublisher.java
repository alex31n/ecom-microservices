package com.bractits.product.service;

import com.bractits.product.data.dto.ProductDTO;
import com.bractits.product.utils.event.ProductEvent;
import com.bractits.product.utils.event.Action;
import com.bractits.product.utils.event.Status;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProductPublisher {

    //    private final Sinks.Many<ProductEvent> productSinks;
//
    private final StreamBridge streamBridge;


    public void send(Action action, ProductDTO product) {
        log.error("ProductPublisher send: action "+action+"  product "+product);
        ProductEvent event = ProductEvent.builder()
                .product(product)
                .action(action)
                .status(Status.SUCCESS)
                .build();

        Message<ProductEvent> message = MessageBuilder.withPayload(event)
                .build();
        streamBridge.send("productSupplier-out-0", message);
    }
}
