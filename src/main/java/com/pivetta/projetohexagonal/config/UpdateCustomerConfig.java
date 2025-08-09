package com.pivetta.projetohexagonal.config;

import com.pivetta.projetohexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.pivetta.projetohexagonal.adapters.out.UpdateCustomerAdapter;
import com.pivetta.projetohexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.pivetta.projetohexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(
                findCustomerByIdUseCase,
                findAddressByZipCodeAdapter,
                updateCustomerAdapter);
    }
}
