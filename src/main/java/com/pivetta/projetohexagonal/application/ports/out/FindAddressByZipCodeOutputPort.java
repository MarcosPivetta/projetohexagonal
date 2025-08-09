package com.pivetta.projetohexagonal.application.ports.out;

import com.pivetta.projetohexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
