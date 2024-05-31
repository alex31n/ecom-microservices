package com.bractits.product.service;

import com.bractits.product.data.dto.ProductDTO;
import com.bractits.product.utils.event.ProductEvent;
import com.bractits.product.utils.event.Action;
import com.bractits.product.utils.event.Status;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductPublisher {

    //    private final Sinks.Many<ProductEvent> productSinks;
//
    private final StreamBridge streamBridge;


    public void send(ProductDTO product) {
        ProductEvent event = ProductEvent.builder()
                .product(product)
                .action(Action.CREATED)
                .status(Status.SUCCESS)
                .build();

//       return streamBridge.send("product-out-0",event);

//        streamBridge.send("productSupplier-out-0", "This is test event LOL");
        streamBridge.send("productSupplier-out-0", event);
    }
}
