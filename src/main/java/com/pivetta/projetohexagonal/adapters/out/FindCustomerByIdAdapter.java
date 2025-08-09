package com.pivetta.projetohexagonal.adapters.out;

import com.pivetta.projetohexagonal.adapters.out.repository.CustomerRepository;
import com.pivetta.projetohexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.pivetta.projetohexagonal.application.core.domain.Customer;
import com.pivetta.projetohexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public FindCustomerByIdAdapter(
            CustomerRepository customerRepository,
            CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(customerEntityMapper::toCustomer);
    }

    @Override
    public Optional<List<Customer>> findAll() {
        var customerEntities = customerRepository.findAll();
        if (customerEntities.isEmpty()) {
            return Optional.empty();
        }
        List<Customer> customers = customerEntities.stream()
                .map(customerEntityMapper::toCustomer)
                .toList();
        return Optional.of(customers);
    }
}
