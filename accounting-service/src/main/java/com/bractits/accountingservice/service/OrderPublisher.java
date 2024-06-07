package com.bractits.accountingservice.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class OrderPublisher {

//
    private final StreamBridge streamBridge;


    /*public void send(Action action, ProductDTO product) {
        log.error("ProductPublisher send: action "+action+"  product "+product);
        ProductEvent event = ProductEvent.builder()
                .product(product)
                .action(action)
                .status(Status.SUCCESS)
                .build();

        Message<ProductEvent> message = MessageBuilder.withPayload(event)
                .build();
        streamBridge.send("productSupplier-out-0", message);
    }*/
}
