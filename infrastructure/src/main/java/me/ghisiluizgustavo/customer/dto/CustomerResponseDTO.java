package me.ghisiluizgustavo.customer.dto;

import me.ghisiluizgustavo.domain.customer.model.Customer;

public record CustomerResponseDTO(
        String id,
        String name,
        String email
) {
    public CustomerResponseDTO(Customer customer){
        this(
                customer.id().value(),
                customer.name(),
                customer.email()
        );
    }
}
