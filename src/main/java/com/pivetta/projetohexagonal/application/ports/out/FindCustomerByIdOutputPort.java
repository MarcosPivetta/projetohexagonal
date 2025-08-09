package com.pivetta.projetohexagonal.application.ports.out;

import com.pivetta.projetohexagonal.application.core.domain.Customer;
import java.util.List;
import java.util.Optional;

public interface FindCustomerByIdOutputPort {
    Optional<Customer> find(String id);

    Optional<List<Customer>> findAll();
}
