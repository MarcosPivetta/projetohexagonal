package com.pivetta.projetohexagonal.application.core.usecase;

import com.pivetta.projetohexagonal.application.core.domain.Customer;
import com.pivetta.projetohexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.pivetta.projetohexagonal.application.ports.in.UpdateCustomerInputPort;
import com.pivetta.projetohexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.pivetta.projetohexagonal.application.ports.out.UpdateCustomerOutputPort;

public record UpdateCustomerUseCase(
        FindCustomerByIdInputPort findCustomerByIdInputPort,
        FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
        UpdateCustomerOutputPort updateCustomerOutputPort) implements UpdateCustomerInputPort {

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
