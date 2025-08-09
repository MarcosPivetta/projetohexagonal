package com.pivetta.projetohexagonal.application.ports.in;

import com.pivetta.projetohexagonal.application.core.domain.Customer;
import java.util.List;
import java.util.Optional;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
    Optional<List<Customer>> findAll();
}
