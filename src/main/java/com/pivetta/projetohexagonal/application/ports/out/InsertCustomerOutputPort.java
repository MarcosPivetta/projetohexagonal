package com.pivetta.projetohexagonal.application.ports.out;

import com.pivetta.projetohexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
    void insert(Customer customer);
}
