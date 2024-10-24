package me.ghisiluizgustavo.infrastructure.customer.gateway;

import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.infrastructure.customer.db.entity.CustomerEntity;
import me.ghisiluizgustavo.infrastructure.customer.db.repository.CustomerRepository;
import me.ghisiluizgustavo.domain.customer.exception.CustomerNotFoundException;
import me.ghisiluizgustavo.domain.customer.gateway.CustomerPersistenceGateway;
import me.ghisiluizgustavo.domain.customer.model.Customer;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerDatabaseGateway implements CustomerPersistenceGateway {

    private final CustomerRepository customerRepository;


    @Override
    public Customer findById(String id) {
        return customerRepository
                .findById(id)
                .map(CustomerEntity::toCustomer)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id: " + id + " was not found"));
    }

}
