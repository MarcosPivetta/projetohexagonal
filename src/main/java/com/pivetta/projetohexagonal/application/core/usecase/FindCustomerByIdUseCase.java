package com.pivetta.projetohexagonal.application.core.usecase;

import com.pivetta.projetohexagonal.application.core.domain.Customer;
import com.pivetta.projetohexagonal.application.core.exceptions.ObjectNotFoundException;
import com.pivetta.projetohexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.pivetta.projetohexagonal.application.ports.out.FindCustomerByIdOutputPort;
import java.util.List;
import java.util.Optional;

public record FindCustomerByIdUseCase(
        FindCustomerByIdOutputPort findCustomerByIdOutputPort) implements FindCustomerByIdInputPort {

    @Override
    public Customer find(String id) {
        return findCustomerByIdOutputPort.find(id)
                .orElseThrow(() -> new ObjectNotFoundException(id));
    }

    @Override
    public Optional<List<Customer>> findAll() {
        return findCustomerByIdOutputPort.findAll();
    }
}
