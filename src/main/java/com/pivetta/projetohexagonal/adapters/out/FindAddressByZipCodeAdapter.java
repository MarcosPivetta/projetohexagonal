package com.pivetta.projetohexagonal.adapters.out;

import com.pivetta.projetohexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.pivetta.projetohexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.pivetta.projetohexagonal.application.core.domain.Address;
import com.pivetta.projetohexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    private final FindAddressByZipCodeClient findAddressByZipCodeClient;
    private final AddressResponseMapper addressResponseMapper;

    public FindAddressByZipCodeAdapter(
            FindAddressByZipCodeClient findAddressByZipCodeClient,
            AddressResponseMapper addressResponseMapper) {
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
        this.addressResponseMapper = addressResponseMapper;
    }

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
