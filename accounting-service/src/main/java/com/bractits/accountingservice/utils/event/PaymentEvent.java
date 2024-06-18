package com.bractits.accountingservice.utils.event;

import com.bractits.accountingservice.data.dto.PaymentDTO;
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

    private final UUID id = UUID.randomUUID();

    private final LocalDateTime date = LocalDateTime.now();

    private PaymentDTO data;

    private PaymentAction action;

    private Status status;

}
