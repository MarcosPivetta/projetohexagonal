package com.pivetta.projetohexagonal.adapters.in.consumer;

import com.pivetta.projetohexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.pivetta.projetohexagonal.adapters.in.consumer.message.CustomerMessage;
import com.pivetta.projetohexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final CustomerMessageMapper customerMessageMapper;

    public ReceiveValidatedCpfConsumer(UpdateCustomerInputPort updateCustomerInputPort, CustomerMessageMapper customerMessageMapper) {
        this.updateCustomerInputPort = updateCustomerInputPort;
        this.customerMessageMapper = customerMessageMapper;
    }


    @KafkaListener(topics = "tp-cpf-validated", groupId = "pivetta")
    public void receive(CustomerMessage customerMessage) {
        updateCustomerInputPort.update(
                customerMessageMapper.toCustomer(customerMessage),
                customerMessage.getZipCode()
        );
    }
}
