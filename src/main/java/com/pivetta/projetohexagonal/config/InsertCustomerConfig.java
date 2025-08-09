package com.pivetta.projetohexagonal.config;

import com.pivetta.projetohexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.pivetta.projetohexagonal.adapters.out.InsertCustomerAdapter;
import com.pivetta.projetohexagonal.adapters.out.SendCpfForValidationAdapter;
import com.pivetta.projetohexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfForValidationAdapter sendCpfForValidationAdapter
    ) {
        return new InsertCustomerUseCase(
                findAddressByZipCodeAdapter,
                insertCustomerAdapter,
                sendCpfForValidationAdapter);
    }
}
