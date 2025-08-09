package com.pivetta.projetohexagonal.adapters.in.controller;

import com.pivetta.projetohexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.pivetta.projetohexagonal.adapters.in.controller.request.CustomerRequest;
import com.pivetta.projetohexagonal.adapters.in.controller.response.CustomerResponse;
import com.pivetta.projetohexagonal.application.core.domain.Customer;
import com.pivetta.projetohexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.pivetta.projetohexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.pivetta.projetohexagonal.application.ports.in.InsertCustomerInputPort;
import com.pivetta.projetohexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final CustomerMapper customerMapper;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    public CustomerController(
            InsertCustomerInputPort insertCustomerInputPort,
            CustomerMapper customerMapper,
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            UpdateCustomerInputPort updateCustomerInputPort,
            DeleteCustomerByIdInputPort deleteCustomerByIdInputPort) {
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.customerMapper = customerMapper;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.updateCustomerInputPort = updateCustomerInputPort;
        this.deleteCustomerByIdInputPort = deleteCustomerByIdInputPort;
    }

    @GetMapping
    public ResponseEntity<Optional<List<CustomerResponse>>> findAll() {

        Optional<List<Customer>> customers = findCustomerByIdInputPort.findAll();
        List<CustomerResponse> customerResponses = customers.stream()
                .flatMap(List::stream)
                .map(customerMapper::toCustomerResponse)
                .toList();
        return ResponseEntity.ok().body(Optional.of(customerResponses));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        insertCustomerInputPort.insert(
                customerMapper.toCustomer(customerRequest),
                customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable final String id,
            @Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
