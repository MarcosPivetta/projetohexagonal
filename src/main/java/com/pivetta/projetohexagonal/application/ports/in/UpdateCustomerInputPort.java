package com.pivetta.projetohexagonal.application.ports.in;

import com.pivetta.projetohexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
    void update(Customer customer, String zipCode);
}
