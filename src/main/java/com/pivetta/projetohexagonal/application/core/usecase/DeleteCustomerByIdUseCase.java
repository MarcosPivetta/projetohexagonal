package com.pivetta.projetohexagonal.application.core.usecase;

import com.pivetta.projetohexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.pivetta.projetohexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.pivetta.projetohexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

public record DeleteCustomerByIdUseCase(
        FindCustomerByIdInputPort findCustomerByIdInputPort,
        DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) implements DeleteCustomerByIdInputPort {

    @Override
    public void delete(String id) {
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);

    }
}
