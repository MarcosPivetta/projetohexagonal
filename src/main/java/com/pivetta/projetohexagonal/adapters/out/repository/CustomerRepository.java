package com.pivetta.projetohexagonal.adapters.out.repository;

import com.pivetta.projetohexagonal.adapters.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CustomerRepository  extends MongoRepository<CustomerEntity, String> {
}
