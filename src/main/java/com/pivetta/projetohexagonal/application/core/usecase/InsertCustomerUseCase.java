package com.pivetta.projetohexagonal.application.core.usecase;

import com.pivetta.projetohexagonal.application.core.domain.Customer;
import com.pivetta.projetohexagonal.application.ports.in.InsertCustomerInputPort;
import com.pivetta.projetohexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.pivetta.projetohexagonal.application.ports.out.InsertCustomerOutputPort;
import com.pivetta.projetohexagonal.application.ports.out.SendCpfForValidationOutputPort;

public record InsertCustomerUseCase(
        FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
        InsertCustomerOutputPort insertCustomerOutputPort,
        SendCpfForValidationOutputPort sendCpfForValidationOutputPort) implements InsertCustomerInputPort {

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }
}
