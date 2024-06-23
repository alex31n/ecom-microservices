package com.bractits.orderservice.orchestrator;

import com.bractits.orderservice.data.entity.Order;
import com.bractits.orderservice.service.OrderService;
import com.bractits.orderservice.utils.event.payment.PaymentEvent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PaymentHandler {

    private final OrderService orderService;

    public void paymentProcess(PaymentEvent event){
        System.out.println("Payment processed!");
        switch (event.getAction()){
            case PAID -> {
                orderService.updateStatus(event.getData().getOrderId(), Order.Status.PAYMENT_SUCCESS);
            }
            case REFUNDED -> {
                orderService.updateStatus(event.getData().getOrderId(), Order.Status.REFUNDED);
            }
            case FAILED -> {
                orderService.updateStatus(event.getData().getOrderId(), Order.Status.PAYMENT_FAILED);
            }

        }
    }
}
