package com.pivetta.projetohexagonal.adapters.in.controller.mapper;

import com.pivetta.projetohexagonal.adapters.in.controller.request.CustomerRequest;
import com.pivetta.projetohexagonal.adapters.in.controller.response.CustomerResponse;
import com.pivetta.projetohexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    @Mapping(source = "validCpf", target = "isValidCpf")
    CustomerResponse toCustomerResponse(Customer customer);
}
