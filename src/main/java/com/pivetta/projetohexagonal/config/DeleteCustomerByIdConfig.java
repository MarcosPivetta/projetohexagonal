package com.pivetta.projetohexagonal.config;

import com.pivetta.projetohexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.pivetta.projetohexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.pivetta.projetohexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase (
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ) {
        return new DeleteCustomerByIdUseCase(
                findCustomerByIdUseCase,
                deleteCustomerByIdAdapter
        );
    }
}
