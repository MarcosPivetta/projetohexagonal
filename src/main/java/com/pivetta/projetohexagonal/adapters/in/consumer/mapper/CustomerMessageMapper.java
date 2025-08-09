package com.pivetta.projetohexagonal.adapters.in.consumer.mapper;

import com.pivetta.projetohexagonal.adapters.in.consumer.message.CustomerMessage;
import com.pivetta.projetohexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
