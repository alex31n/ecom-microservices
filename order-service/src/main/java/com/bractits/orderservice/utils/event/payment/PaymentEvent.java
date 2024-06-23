package com.bractits.orderservice.utils.event.payment;

import com.bractits.orderservice.data.dto.PaymentDTO;
import com.bractits.orderservice.utils.event.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEvent {

    public enum PaymentAction {

        WAITING,
        PAID,
        FAILED,
        REFUNDED,
        CANCELED
    }

    private final UUID id = UUID.randomUUID();

    private final LocalDateTime date = LocalDateTime.now();

    private PaymentDTO data;

    private PaymentAction action;

    private Status status;

}
