package com.bractits.accountingservice.utils.mapper;

import com.bractits.accountingservice.data.dto.OrderDTO;
import com.bractits.accountingservice.data.dto.PaymentDTO;
import com.bractits.accountingservice.data.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    Payment toEntity(PaymentDTO dto);

    PaymentDTO toDto(Payment entity);

}
