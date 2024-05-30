package com.bractits.common.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseEvent {

    private UUID id = UUID.randomUUID();
    private LocalDateTime date = LocalDateTime.now();

}
