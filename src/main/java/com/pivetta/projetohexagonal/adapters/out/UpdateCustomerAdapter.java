package com.pivetta.projetohexagonal.adapters.out;

import com.pivetta.projetohexagonal.adapters.out.repository.CustomerRepository;
import com.pivetta.projetohexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.pivetta.projetohexagonal.application.core.domain.Customer;
import com.pivetta.projetohexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public UpdateCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customerEntityMapper.toCustomerEntity(customer));
    }
}
