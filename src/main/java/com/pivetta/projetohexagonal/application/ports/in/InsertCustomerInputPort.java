package com.pivetta.projetohexagonal.application.ports.in;

import com.pivetta.projetohexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {
    void insert(Customer customer, String zipCode);
}
