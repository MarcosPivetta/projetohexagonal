package com.pivetta.projetohexagonal.adapters.out.client.mapper;

import com.pivetta.projetohexagonal.adapters.out.client.response.AddressResponse;
import com.pivetta.projetohexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
